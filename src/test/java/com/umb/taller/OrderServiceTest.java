package com.umb.taller;

import com.umb.taller.application.OrderFilter;
import com.umb.taller.application.OrderService;
import com.umb.taller.domain.Order;
import com.umb.taller.domain.Product;
import com.umb.taller.domain.exceptions.InsufficientStockException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderServiceTest {

    @Test
    void testProcessOrderSuccess() throws Exception {
        OrderService service = new OrderService();
        Order order = new Order("ORD-001", "test@umb.edu.co");
        Product product = new Product("PROD-001", "Laptop", 1200.0, 10);

        service.processOrder(order, product, 2);

        assertThat(product.getStock()).isEqualTo(8);
        assertThat(order.getItems()).hasSize(1);
        assertThat(order.getStatus()).isEqualTo("PROCESSED");
    }

    @Test
    void testProcessOrderInsufficientStockThrowsException() {
        OrderService service = new OrderService();
        Order order = new Order("ORD-002", "test@umb.edu.co");
        Product product = new Product("PROD-002", "Mouse", 25.0, 1);

        assertThatThrownBy(() -> service.processOrder(order, product, 5))
                .isInstanceOf(InsufficientStockException.class)
                .hasMessageContaining("PROD-002");
    }

    @Test
    void testAddNullProductThrowsException() {
        Order order = new Order("ORD-003", "test@umb.edu.co");
        assertThatThrownBy(() -> order.addProduct(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("cannot be null");
    }

    @Test
    void testNewOrderStartsAsPending() {
        Order order = new Order("ORD-004", "test@umb.edu.co");
        assertThat(order.getStatus()).isEqualTo("PENDING");
    }

    @Test
    void testFilterOrdersWithLambdasAndMethodReference() {
        Order pending = new Order("ORD-010", "ana@umb.edu.co");
        Order processed = new Order("ORD-011", "luis@umb.edu.co");
        processed.setStatus("PROCESSED");
        List<Order> orders = List.of(pending, processed);

        OrderFilter byProcessedStatus = order -> "PROCESSED".equals(order.getStatus());
        OrderFilter byUmbEmail = order -> order.getCustomerEmail().endsWith("@umb.edu.co");
        OrderFilter byEmptyItems = order -> order.getItems().isEmpty();
        OrderFilter byPendingStatus = Order::isPending; // method reference

        OrderService service = new OrderService();

        assertThat(service.filterOrders(orders, byProcessedStatus)).containsExactly(processed);
        assertThat(service.filterOrders(orders, byUmbEmail)).hasSize(2);
        assertThat(service.filterOrders(orders, byEmptyItems)).hasSize(2);
        assertThat(service.filterOrders(orders, byPendingStatus)).containsExactly(pending);
    }
}
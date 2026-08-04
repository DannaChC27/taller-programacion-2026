package com.umb.taller;

import com.umb.taller.application.OrderService;
import com.umb.taller.domain.Order;
import com.umb.taller.domain.Product;
import com.umb.taller.domain.exceptions.InsufficientStockException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void testProcessOrderSuccess() {
        OrderService service = new OrderService();
        Order order = new Order("ORD-001", "test@umb.edu.co");
        Product product = new Product("PROD-001", "Laptop", 1200.0, 10);

        service.processOrder(order, product, 2);

        assertEquals(8, product.getStock());
        assertEquals(1, order.getItems().size());
        assertEquals("PROCESSED", order.getStatus());
    }

    @Test
    void testProcessOrderInsufficientStockThrowsException() {
        OrderService service = new OrderService();
        Order order = new Order("ORD-002", "test@umb.edu.co");
        Product product = new Product("PROD-002", "Mouse", 25.0, 1);

        assertThrows(InsufficientStockException.class, () -> {
            service.processOrder(order, product, 5);
        });
    }
}

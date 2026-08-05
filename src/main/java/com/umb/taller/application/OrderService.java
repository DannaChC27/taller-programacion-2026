package com.umb.taller.application;

import com.umb.taller.domain.Order;
import com.umb.taller.domain.Product;
import com.umb.taller.domain.exceptions.InsufficientStockException;
import com.umb.taller.infrastructure.InMemoryRepository;
import com.umb.taller.infrastructure.Repository;

import java.util.List;

public class OrderService {

    private final Repository<Order, String> orderRepository;

    public OrderService() {
        this(new InMemoryRepository<>());
    }

    public OrderService(Repository<Order, String> orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> filterOrders(List<Order> orders, OrderFilter filter) {
        return orders.stream()
                .filter(filter::test)
                .toList();
    }

    public void processOrder(Order order, Product product, int quantity) throws InsufficientStockException {
        if (product.getStock() < quantity) {
            throw new InsufficientStockException(product.getId(), quantity);
        }
        product.reduceStock(quantity);
        order.addProduct(product);
        order.setStatus("PROCESSED");
        orderRepository.save(order);
    }
}
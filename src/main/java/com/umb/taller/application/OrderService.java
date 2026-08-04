package com.umb.taller.application;

import com.umb.taller.domain.Order;
import com.umb.taller.domain.Product;
import com.umb.taller.domain.exceptions.InsufficientStockException;

import java.util.List;

@FunctionalInterface
interface OrderFilter {
    boolean test(Order order);
}

public class OrderService {

    // Functional Programming: Using Custom Lambda / Functional Interface
    public List<Order> filterOrders(List<Order> orders, OrderFilter filter) {
        return orders.stream()
                .filter(filter::test)
                .toList();
    }

    // Business Operation demonstrating Custom Exception Throwing
    public void processOrder(Order order, Product product, int quantity) {
        if (product.getStock() < quantity) {
            throw new InsufficientStockException(product.getId(), quantity);
        }
        product.reduceStock(quantity);
        order.addProduct(product);
        order.setStatus("PROCESSED");
    }
}
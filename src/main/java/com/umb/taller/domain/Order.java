package com.umb.taller.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order extends Entity implements Calculable {
    private final String customerEmail;
    private final List<Product> items;
    private String status;

    public Order(String id, String customerEmail) {
        super(id);
        this.customerEmail = customerEmail;
        this.items = new ArrayList<>();
        this.status = "PENDING";
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.items.add(product);
    }

    public List<Product> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public double calculateTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
}
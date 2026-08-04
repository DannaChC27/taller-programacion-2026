package com.umb.taller.domain.exceptions;

public class InsufficientStockException extends OrderException {
    private final String productId;

    public InsufficientStockException(String productId, String message) {
        super(message);
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
package com.umb.taller.domain.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsufficientStockException extends OrderException {
    private static final Logger logger = LoggerFactory.getLogger(InsufficientStockException.class);

    private final String productId;
    private final int requestedQuantity;

    public InsufficientStockException(String productId, int requestedQuantity) {
        super(String.format("Stock insuficiente para el producto ID: %s. Cantidad solicitada: %d",
                productId, requestedQuantity));
        this.productId = productId;
        this.requestedQuantity = requestedQuantity;
        logger.warn("InsufficientStockException -> productId={}, requested={}", productId, requestedQuantity);
    }

    public String getProductId() { return productId; }
    public int getRequestedQuantity() { return requestedQuantity; }
}
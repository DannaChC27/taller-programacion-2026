package com.umb.taller.domain.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderException extends DomainException {
    private static final Logger logger = LoggerFactory.getLogger(OrderException.class);

    public OrderException(String message) {
        super(message);
        logger.warn("OrderException: {}", message);
    }
}
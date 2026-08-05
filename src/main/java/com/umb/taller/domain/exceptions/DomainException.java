package com.umb.taller.domain.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DomainException extends Exception {
    private static final Logger logger = LoggerFactory.getLogger(DomainException.class);

    public DomainException(String message) {
        super(message);
        logger.error("DomainException: {}", message);
    }
}
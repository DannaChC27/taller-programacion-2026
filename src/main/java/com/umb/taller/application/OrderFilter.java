package com.umb.taller.application;

import com.umb.taller.domain.Order;

@FunctionalInterface
public interface OrderFilter {
    boolean test(Order order);
}
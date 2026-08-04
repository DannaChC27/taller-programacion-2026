package com.umb.taller.domain;

import java.time.LocalDateTime;

public abstract class Entity {
    private final String id;
    private final LocalDateTime createdAt;

    public Entity(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Entity ID cannot be null or empty.");
        }
        this.id = id;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
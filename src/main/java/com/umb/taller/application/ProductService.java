package com.umb.taller.application;

import com.umb.taller.domain.Product;
import com.umb.taller.infrastructure.InMemoryRepository;
import com.umb.taller.infrastructure.Repository;

import java.util.Optional;

public class ProductService {

    private final Repository<Product, String> productRepository;

    public ProductService() {
        this(new InMemoryRepository<>());
    }

    public ProductService(Repository<Product, String> productRepository) {
        this.productRepository = productRepository;
    }

    public Product registerProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findProduct(String id) {
        return productRepository.findById(id);
    }
}
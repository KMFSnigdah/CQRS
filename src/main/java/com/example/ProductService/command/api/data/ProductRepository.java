package com.example.ProductService.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public void deleteByProductId(long productId);
    public Optional<Product> findByProductId(long productId);
}

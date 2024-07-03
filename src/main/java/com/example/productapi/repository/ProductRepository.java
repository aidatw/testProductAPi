package com.example.productapi.repository;

import com.example.productapi.model.Product;

import java.util.Optional; // Import the correct List class
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Add custom query methods if needed
    Optional<Product> findBySku(String sku);
    List<Product> findByCategory(String category);
    Page<Product> findByNameContaining(String keyword, Pageable pageable);
}
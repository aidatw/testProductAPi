package com.example.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;


@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository; // Assuming you have a ProductRepository injected

    @GetMapping("/products")
    public Page<Product> searchByKeyword(
            @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "15") int size) {
        size = Math.min(size, 30); // Ensure size does not exceed the maximum limit of 30
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByNameContaining(keyword, pageable);
    }
}
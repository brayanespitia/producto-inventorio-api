package com.example.application.service;

import com.example.application.dto.CreateProductRequest;
import com.example.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product create(CreateProductRequest request);

    Optional<Product> findById(Long id);
    List<Product> findAll();
}

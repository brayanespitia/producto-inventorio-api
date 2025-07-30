package com.example.application.service;

import com.example.application.dto.CreateProductRequest;
import com.example.domain.model.Product;

public interface ProductService {

    Product create(CreateProductRequest request);
}

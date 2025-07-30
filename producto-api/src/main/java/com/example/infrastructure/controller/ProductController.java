package com.example.infrastructure.controller;


import com.example.JsonApiResponse;
import com.example.application.dto.CreateProductRequest;
import com.example.application.service.ProductService;
import com.example.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<JsonApiResponse<Product>> create(@RequestBody CreateProductRequest request) {
        Product product = productService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new JsonApiResponse<>(product));
    }



}

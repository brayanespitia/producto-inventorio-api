package com.example.application.service;


import com.example.application.dto.CreateProductRequest;
import com.example.domain.model.Product;
import com.example.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(CreateProductRequest request) {
        Product product = new Product(null, request.getNombre(), request.getPrecio(), request.getDescripcion());

        return productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

}

package com.example.application.service;

import com.example.application.dto.CreateProductRequest;
import com.example.domain.model.Product;
import com.example.domain.repository.ProductRepository;
import com.example.infrastructure.persistence.entity.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService  {

    private final ProductRepository productRepository;
    @Override
    public Product create(CreateProductRequest request) {
        Product product = new Product(null, request.getNombre(), request.getPrecio(), request.getDescripcion());
        return productRepository.save(product);
    }
}

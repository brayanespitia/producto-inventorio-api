package com.example.application.service;

import com.example.application.dto.CreateProductRequest;
import com.example.domain.model.Product;
import com.example.domain.repository.ProductRepository;
import com.example.infrastructure.persistence.entity.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService  {

    private final ProductRepository productRepository;
    @Override
    public Product create(CreateProductRequest request) {
        Product product = new Product(null, request.getNombre(), request.getPrecio(), request.getDescripcion());
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}

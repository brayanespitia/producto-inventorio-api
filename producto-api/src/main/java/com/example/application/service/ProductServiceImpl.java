package com.example.application.service;

import com.example.application.dto.CreateProductRequest;
import com.example.application.dto.InventoryResponse;
import com.example.domain.model.Product;
import com.example.domain.repository.ProductRepository;
import com.example.infrastructure.client.InventoryClient;
import com.example.infrastructure.persistence.entity.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService  {

    private final ProductRepository productRepository;


    private final InventoryClient inventoryClient;
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

    @Override
    public Integer getAvailableQuantity(Long productId) {
        try {
            InventoryResponse response = inventoryClient.getInventoryByProductId(productId);
            return response.getQuantity();
        } catch (Exception ex) {

            System.err.println("Error al consultar la cantidad disponible del producto " + productId + ": " + ex.getMessage());
            return 0;
        }
    }

}

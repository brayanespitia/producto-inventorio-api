package com.example.domain.repository;

import com.example.domain.model.Product;
import com.example.infrastructure.persistence.entity.JpaProductRepository;
import com.example.infrastructure.persistence.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    private final ModelMapper modelMapper;


    @Override
    public Product save(Product product) {
        ProductEntity entity = modelMapper.map(product, ProductEntity.class);
        ProductEntity savedEntity = jpaProductRepository.save(entity);
        return modelMapper.map(savedEntity, Product.class);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}

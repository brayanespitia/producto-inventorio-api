package com.example.infrastructure.persistence.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}

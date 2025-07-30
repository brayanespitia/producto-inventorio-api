package com.example.infrastructure.persistence.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}

package com.example.inventario.infraestructure.persistence;

import com.example.inventario.infraestructure.persistence.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaInventoryRepository extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> findByProductId(Long productId);
}

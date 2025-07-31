package com.example.inventario.dominio.repository;

import com.example.inventario.dominio.model.Inventory;

import java.util.Optional;

public interface InventoryRepository {
    Optional<Inventory> findByProductId(Long productId);
    Inventory save(Inventory inventory);
}

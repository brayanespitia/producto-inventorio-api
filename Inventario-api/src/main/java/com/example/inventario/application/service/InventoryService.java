package com.example.inventario.application.service;

import com.example.inventario.application.dto.InventoryWithProductDTO;
import com.example.inventario.dominio.model.Inventory;

import java.util.Optional;

public interface InventoryService {
    Optional<Inventory> getByProductId(Long productId);
    Inventory updateQuantity(Long productId, int quantity);

    Optional<InventoryWithProductDTO> getInventoryWithProduct(Long productId);
}

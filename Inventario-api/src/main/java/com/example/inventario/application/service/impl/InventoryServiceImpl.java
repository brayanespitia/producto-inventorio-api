package com.example.inventario.application.service.impl;

import com.example.inventario.application.dto.InventoryWithProductDTO;
import com.example.inventario.application.dto.ProductResponse;
import com.example.inventario.application.service.InventoryService;
import com.example.inventario.dominio.model.Inventory;
import com.example.inventario.dominio.repository.InventoryRepository;
import com.example.inventario.infraestructure.client.ProductClient;
import com.example.inventario.infraestructure.config.InventoryMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductClient productClient;

    private final InventoryMapper inventoryMapper;

    @Override
    public Optional<Inventory> getByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId);
    }

    @Override
    public Inventory updateQuantity(Long productId, int quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElse(new Inventory(productId, 0));

        inventory.setQuantity(quantity);
        return inventoryRepository.save(inventory);
    }

    @Override
    public Optional<InventoryWithProductDTO> getInventoryWithProduct(Long productId) {
        return inventoryRepository.findByProductId(productId)
                .map(inventory -> {
                    ProductResponse product = productClient.getProductById(productId);
                    return inventoryMapper.toDto(product, inventory);
                });
    }


}

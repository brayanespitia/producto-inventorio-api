package com.example.inventario.application.service.impl;

import com.example.inventario.application.dto.ProductResponse;
import com.example.inventario.application.dto.PurchaseResponse;
import com.example.inventario.application.service.PurchaseService;
import com.example.inventario.dominio.model.Inventory;
import com.example.inventario.dominio.repository.InventoryRepository;
import com.example.inventario.infraestructure.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final InventoryRepository inventoryRepository;

    private final ProductClient productClient;
    @Override
    public PurchaseResponse purchaseProduct(Long productId, int quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado en el inventario"));
        if (inventory.getQuantity() < quantity) {
            throw new IllegalStateException("inventario insuficiente");
        }
        inventory.setQuantity(inventory.getQuantity() - quantity);
        inventoryRepository.save(inventory);
        ProductResponse product = productClient.getProductById(productId);

        BigDecimal price = product.getPrice();
        BigDecimal total = price.multiply(BigDecimal.valueOf(quantity));

        return new PurchaseResponse(
                productId,
                product.getName(),
                price,
                quantity,
                total
        );
    }


}

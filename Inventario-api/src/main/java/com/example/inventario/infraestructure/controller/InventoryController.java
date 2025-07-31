package com.example.inventario.infraestructure.controller;

import com.example.inventario.application.dto.InventoryWithProductDTO;
import com.example.inventario.application.dto.UpdateInventoryRequest;
import com.example.inventario.application.service.InventoryService;
import com.example.inventario.dominio.model.Inventory;
import com.example.inventario.infraestructure.config.JsonApiData;
import com.example.inventario.infraestructure.config.JsonApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{productId}")
    public ResponseEntity<JsonApiResponse<JsonApiData<Inventory>>> getByProductId(@PathVariable Long productId) {
        return inventoryService.getByProductId(productId)
                .map(inv -> {
                    JsonApiData<Inventory> data = new JsonApiData<>(
                            "inventory",
                            String.valueOf(inv.getProductId()),
                            inv
                    );
                    return ResponseEntity.ok(new JsonApiResponse<>(data));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<JsonApiResponse<Inventory>> updateQuantity(@PathVariable Long productId,
                                                                     @RequestBody UpdateInventoryRequest request) {
        Inventory updated = inventoryService.updateQuantity(productId, request.getQuantity());
        return ResponseEntity.ok(new JsonApiResponse<>(updated));
    }

    @GetMapping("/producto/{productId}")
    public ResponseEntity<InventoryWithProductDTO> getInventoryWithProduct(@PathVariable Long productId) {
        return inventoryService.getInventoryWithProduct(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

package com.example.inventario.infraestructure.config;

import com.example.inventario.application.dto.InventoryWithProductDTO;
import com.example.inventario.application.dto.ProductResponse;
import com.example.inventario.dominio.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryMapper {
    private final ModelMapper modelMapper;

    public InventoryWithProductDTO toDto(ProductResponse product, Inventory inventory) {
        InventoryWithProductDTO dto = modelMapper.map(product, InventoryWithProductDTO.class);
        dto.setQuantity(inventory.getQuantity());
        return dto;
    }
}

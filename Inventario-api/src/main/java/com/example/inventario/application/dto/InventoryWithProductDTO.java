package com.example.inventario.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryWithProductDTO  {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}

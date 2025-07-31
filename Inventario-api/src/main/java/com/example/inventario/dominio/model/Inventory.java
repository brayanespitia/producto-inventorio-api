package com.example.inventario.dominio.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private Long productId;
    private Integer quantity;
}

package com.example.inventario.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PurchaseResponse {
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private int quantityPurchased;
    private BigDecimal totalPrice;
}

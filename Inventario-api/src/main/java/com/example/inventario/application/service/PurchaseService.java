package com.example.inventario.application.service;

import com.example.inventario.application.dto.PurchaseResponse;

public interface PurchaseService {
    PurchaseResponse purchaseProduct(Long productId, int quantity);
}

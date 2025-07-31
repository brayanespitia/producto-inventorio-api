package com.example.inventario.infraestructure.controller;

import com.example.inventario.application.dto.PurchaseRequest;
import com.example.inventario.application.dto.PurchaseResponse;
import com.example.inventario.application.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseUseCase;

    @PostMapping
    public ResponseEntity<PurchaseResponse> purchase(@RequestBody PurchaseRequest request) {
        PurchaseResponse response = purchaseUseCase.purchaseProduct(request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(response);
    }
}

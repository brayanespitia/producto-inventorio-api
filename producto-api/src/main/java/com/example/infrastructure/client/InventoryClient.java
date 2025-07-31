package com.example.infrastructure.client;

import com.example.application.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", url = "http://localhost:8080")
public interface InventoryClient {

    @GetMapping("/api/inventory/{productId}")
    InventoryResponse getInventoryByProductId(@PathVariable("productId") Long productId);
}

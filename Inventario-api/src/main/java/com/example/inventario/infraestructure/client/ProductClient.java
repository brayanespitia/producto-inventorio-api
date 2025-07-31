package com.example.inventario.infraestructure.client;

import com.example.inventario.application.dto.ProductResponse;
import com.example.inventario.infraestructure.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:9057/api/products", configuration = FeignConfig.class)
public interface ProductClient {
    @GetMapping("/{id}")
    ProductResponse getProductById(@PathVariable("id") Long id);
}

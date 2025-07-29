package com.example.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProductRequest {
    private String nombre;
    private Double precio;
    private String descripcion;

}

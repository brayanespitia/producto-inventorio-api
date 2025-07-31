package com.example.inventario.infraestructure.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonApiData<T> {
    private String type;
    private String id;
    private T attributes;
}

package com.example.domain.model;


import lombok.Data;

@Data
public class Product {

    private Long id;

    private String nombre;
    private Double precio;
    private String descripcion;

    public Product(Long id, String nombre, Double precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}

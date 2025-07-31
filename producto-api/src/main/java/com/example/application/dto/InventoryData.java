package com.example.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryData {
    private String type;
    private String id;
    private InventoryAttributes attributes;
}

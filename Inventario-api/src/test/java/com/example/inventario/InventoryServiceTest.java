package com.example.inventario;

import com.example.inventario.application.dto.InventoryWithProductDTO;
import com.example.inventario.application.dto.ProductResponse;
import com.example.inventario.application.service.impl.InventoryServiceImpl;
import com.example.inventario.dominio.model.Inventory;
import com.example.inventario.dominio.repository.InventoryRepository;
import com.example.inventario.infraestructure.client.ProductClient;
import com.example.inventario.infraestructure.config.InventoryMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @Mock
    private ProductClient productClient;

    @Mock
    private InventoryMapper inventoryMapper;

    @InjectMocks
    private InventoryServiceImpl inventoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnInventoryWhenExists() {
        Long productId = 1L;
        Inventory inventory = new Inventory(productId, 10);

        when(inventoryRepository.findByProductId(productId)).thenReturn(Optional.of(inventory));

        Optional<Inventory> result = inventoryService.getByProductId(productId);

        assertTrue(result.isPresent());
        assertEquals(10, result.get().getQuantity());
        verify(inventoryRepository).findByProductId(productId);
    }

    @Test
    void shouldUpdateInventoryQuantityWhenExists() {
        Long productId = 1L;
        Inventory existingInventory = new Inventory(productId, 5);
        Inventory updatedInventory = new Inventory(productId, 20);

        when(inventoryRepository.findByProductId(productId)).thenReturn(Optional.of(existingInventory));
        when(inventoryRepository.save(existingInventory)).thenReturn(updatedInventory);

        Inventory result = inventoryService.updateQuantity(productId, 20);

        assertEquals(20, result.getQuantity());
        verify(inventoryRepository).findByProductId(productId);
        verify(inventoryRepository).save(existingInventory);
    }

    @Test
    void shouldCreateInventoryWhenNotExists() {
        Long productId = 2L;
        Inventory newInventory = new Inventory(productId, 15);

        when(inventoryRepository.findByProductId(productId)).thenReturn(Optional.empty());
        when(inventoryRepository.save(any(Inventory.class))).thenReturn(newInventory);

        Inventory result = inventoryService.updateQuantity(productId, 15);

        assertEquals(15, result.getQuantity());
        verify(inventoryRepository).save(any(Inventory.class));
    }


}

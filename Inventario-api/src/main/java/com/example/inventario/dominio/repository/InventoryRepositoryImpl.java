package com.example.inventario.dominio.repository;

import com.example.inventario.dominio.model.Inventory;
import com.example.inventario.infraestructure.persistence.JpaInventoryRepository;
import com.example.inventario.infraestructure.persistence.entity.InventoryEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InventoryRepositoryImpl implements InventoryRepository {
    private final JpaInventoryRepository jpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Inventory> findByProductId(Long productId) {
        return jpaRepository.findByProductId(productId)
                .map(entity -> modelMapper.map(entity, Inventory.class));
    }

    @Override
    public Inventory save(Inventory inventory) {
        InventoryEntity entity = modelMapper.map(inventory, InventoryEntity.class);
        InventoryEntity saved = jpaRepository.save(entity);
        return modelMapper.map(saved, Inventory.class);
    }
}

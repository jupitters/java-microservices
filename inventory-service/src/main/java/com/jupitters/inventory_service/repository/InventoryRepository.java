package com.jupitters.inventory_service.repository;

import com.jupitters.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityGreaterThanEquals(String skuCode, Integer quantity);
}

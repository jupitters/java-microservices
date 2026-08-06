package com.jupitters.inventory_service.service;

public interface InventoryService {
    boolean isInStock(String skuCode, Integer quantity);
}

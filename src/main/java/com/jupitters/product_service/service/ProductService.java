package com.jupitters.product_service.service;

import com.jupitters.product_service.dto.ProductRequest;
import com.jupitters.product_service.model.Product;

public interface ProductService {
    Product createProduct(ProductRequest request);
}

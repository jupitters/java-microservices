package com.jupitters.product_service.service;

import com.jupitters.product_service.dto.ProductRequest;
import com.jupitters.product_service.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest request);
    List<Product> getAllProducts();
}

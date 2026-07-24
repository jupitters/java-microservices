package com.jupitters.product_service.service.impl;

import com.jupitters.product_service.dto.ProductRequest;
import com.jupitters.product_service.model.Product;
import com.jupitters.product_service.repository.ProductRepository;
import com.jupitters.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }
}

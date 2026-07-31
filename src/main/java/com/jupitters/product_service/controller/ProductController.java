package com.jupitters.product_service.controller;

import com.jupitters.product_service.dto.ProductRequest;
import com.jupitters.product_service.model.Product;
import com.jupitters.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.createProduct(product));
    }

    public ResponseEntity<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}

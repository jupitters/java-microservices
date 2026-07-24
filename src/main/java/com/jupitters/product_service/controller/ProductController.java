package com.jupitters.product_service.controller;

import com.jupitters.product_service.dto.ProductRequest;
import com.jupitters.product_service.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest product) {
        return ResponseEntity.ok();
    }
}

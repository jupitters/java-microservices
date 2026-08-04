package com.jupitters.product_service.service.impl;

import com.jupitters.product_service.dto.ProductRequest;
import com.jupitters.product_service.dto.ProductResponse;
import com.jupitters.product_service.model.Product;
import com.jupitters.product_service.repository.ProductRepository;
import com.jupitters.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();


        productRepository.save(product);

        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(p -> new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice()))
                .toList();
    }

    @Override
    public Product getProductById() {
        return null;
    }
}

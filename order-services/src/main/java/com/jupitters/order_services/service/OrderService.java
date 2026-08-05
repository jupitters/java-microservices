package com.jupitters.order_services.service;

import com.jupitters.order_services.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest request);
}

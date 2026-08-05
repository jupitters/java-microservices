package com.jupitters.order_services.service.impl;

import com.jupitters.order_services.repository.OrderRepository;
import com.jupitters.order_services.service.OrderSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderSerivce {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest request){

    }
}

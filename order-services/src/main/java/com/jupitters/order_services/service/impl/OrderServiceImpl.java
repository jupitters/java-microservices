package com.jupitters.order_services.service.impl;

import com.jupitters.order_services.dto.OrderRequest;
import com.jupitters.order_services.model.Order;
import com.jupitters.order_services.repository.OrderRepository;
import com.jupitters.order_services.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderRequest request){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(request.price());
        order.setSkuCode(request.skuCode());
        order.setQuantity(request.quantity());

        orderRepository.save(order);
    }
}

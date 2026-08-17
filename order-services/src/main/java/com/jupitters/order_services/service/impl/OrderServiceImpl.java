package com.jupitters.order_services.service.impl;

import com.jupitters.order_services.client.InventoryClient;
import com.jupitters.order_services.dto.OrderRequest;
import com.jupitters.order_services.event.OrderPlacedEvent;
import com.jupitters.order_services.model.Order;
import com.jupitters.order_services.repository.OrderRepository;
import com.jupitters.order_services.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    @Override
    public void placeOrder(OrderRequest request){
        boolean isProductInStock = inventoryClient.isInStock(request.skuCode(), request.quantity());

        if(isProductInStock){
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(request.price());
            order.setSkuCode(request.skuCode());
            order.setQuantity(request.quantity());

            orderRepository.save(order);

            OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent();
            orderPlacedEvent.setOrderNumber(order.getOrderNumber());
            orderPlacedEvent.setEmail(request.userDetails().email());
            orderPlacedEvent.setFirstName(request.userDetails().firstName());
            orderPlacedEvent.setLastName(request.userDetails().lastName());
            kafkaTemplate.send("order-placed", orderPlacedEvent);
        } else {
            throw new RuntimeException("Product with SkuCode" + request.skuCode() + " not in stock.");
        }
    }
}

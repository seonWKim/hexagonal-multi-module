package org.example.api.order;

import org.example.domain.order.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order mapToOrder(Long memberId, OrderRequest orderRequest) {
        return new Order(memberId, orderRequest.name(), orderRequest.price());
    }

    public OrderResponse mapToOrderResponse(Order order) {
        return new OrderResponse(order.getName(), order.getPrice());
    }
}

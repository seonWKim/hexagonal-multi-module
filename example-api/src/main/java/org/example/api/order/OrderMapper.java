package org.example.api.order;

import org.example.application.port.in.command.OrderRegisterCommand;
import org.example.domain.order.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderRegisterCommand mapToOrderRegisterCommand(Long memberId, OrderRequest orderRequest) {
        return new OrderRegisterCommand(memberId, orderRequest.name(), orderRequest.price());
    }

    public OrderResponse mapToOrderResponse(Order order) {
        return new OrderResponse(order.getName(), order.getPrice());
    }
}

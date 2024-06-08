package org.example.application.port.in;

import java.util.List;

import org.example.application.port.in.command.OrderRegisterCommand;
import org.example.domain.order.Order;

public interface MemberOrdersOperationPort {
    List<Order> findOrders(Long memberId);

    Long order(Long memberId, OrderRegisterCommand command);
    
    void completeOrder(Long memberId, Long orderId); 

    void cancel(Long memberId, Long orderId);
}

package org.example.application;

import java.util.List;

import org.example.domain.order.Order;

public interface OrderFacade {
    List<Order> findOrders(Long memberId);

    Long order(Long memberId, Order order);
    
    void completeOrder(Long memberId, Long orderId); 

    void cancel(Long memberId, Long orderId);
}

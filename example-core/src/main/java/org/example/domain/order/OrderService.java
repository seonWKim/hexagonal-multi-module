package org.example.domain.order;

import java.util.List;

public interface OrderService {

    Order findById(Long orderId);

    List<Order> findOrdersByMemberId(Long memberId);

    List<Order> findCompletedOrders(Long lastId, int size);

    Long registerOrder(Order order);

    void saveCompletedOrders(List<CompletedOrderHistory> completedOrderHistories);
    void completeOrder(Order order);

    void deleteOrderById(Long orderId);
}

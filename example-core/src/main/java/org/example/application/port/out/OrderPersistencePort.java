package org.example.application.port.out;

import java.util.List;

import org.example.domain.order.CompletedOrderHistory;
import org.example.domain.order.Order;

public interface OrderPersistencePort {

    Order findById(Long id);

    List<Order> findCompletedOrders(Long lastId, int size);

    List<Order> findByMemberId(Long memberId);

    Long save(Order order);

    void saveAll(List<CompletedOrderHistory> completedOrderHistories);

    void delete(Long id);
}

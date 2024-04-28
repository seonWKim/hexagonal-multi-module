package org.example.domain.order;

import java.util.List;

public interface OrderRepository {

    Order findById(Long id);

    List<Order> findCompletedOrders(Long lastId, int size);

    List<Order> findByMemberId(Long memberId);

    Long save(Order order);

    void saveAll(List<CompletedOrderHistory> completedOrderHistories);

    void delete(Long id);
}

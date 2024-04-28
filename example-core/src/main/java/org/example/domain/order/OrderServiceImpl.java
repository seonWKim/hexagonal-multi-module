package org.example.domain.order;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Transactional(readOnly = true)
    public List<Order> findOrdersByMemberId(Long memberId) {
        return orderRepository.findByMemberId(memberId);
    }

    @Override
    public List<Order> findCompletedOrders(Long lastId, int size) {
        return orderRepository.findCompletedOrders(lastId, size);
    }

    @Transactional
    public Long registerOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public void saveCompletedOrders(List<CompletedOrderHistory> completedOrderHistories) {
        orderRepository.saveAll(completedOrderHistories);
    }

    @Transactional
    public void completeOrder(Order order) {
        order.complete();
        orderRepository.save(order);
    }

    @Transactional
    public void deleteOrderById(Long orderId) {
        orderRepository.delete(orderId);
    }
}

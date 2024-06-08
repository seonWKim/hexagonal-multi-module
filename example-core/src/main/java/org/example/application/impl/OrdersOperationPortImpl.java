package org.example.application.impl;

import java.util.List;

import org.example.application.port.in.OrdersOperationPort;
import org.example.application.port.in.command.OrderCompleteCommand;
import org.example.application.port.in.command.OrderRegisterCommand;
import org.example.application.port.in.command.SaveOrderHistoriesCommand;
import org.example.application.port.out.OrderPersistencePort;
import org.example.domain.order.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class OrdersOperationPortImpl implements OrdersOperationPort {
    private final OrderPersistencePort orderRepository;

    public OrdersOperationPortImpl(OrderPersistencePort orderRepository) {
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

    @Override
    @Transactional
    public Long registerOrder(OrderRegisterCommand command) {
        Order order = new Order(command.memberId(), command.name(), command.price());
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public void saveHistories(SaveOrderHistoriesCommand command) {
        orderRepository.saveAll(command.completedOrderHistories());
    }

    @Override
    @Transactional
    public void completeOrder(OrderCompleteCommand command) {
        var entity = orderRepository.findById(command.orderId());
        entity.complete();
    }

    @Transactional
    public void deleteOrderById(Long orderId) {
        orderRepository.delete(orderId);
    }
}

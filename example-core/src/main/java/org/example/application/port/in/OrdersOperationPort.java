package org.example.application.port.in;

import java.util.List;

import org.example.application.port.in.command.OrderCompleteCommand;
import org.example.application.port.in.command.OrderRegisterCommand;
import org.example.application.port.in.command.SaveOrderHistoriesCommand;
import org.example.domain.order.Order;

public interface OrdersOperationPort {

    Order findById(Long orderId);

    List<Order> findOrdersByMemberId(Long memberId);

    List<Order> findCompletedOrders(Long lastId, int size);

    Long registerOrder(OrderRegisterCommand command);

    void saveHistories(SaveOrderHistoriesCommand command);

    void completeOrder(OrderCompleteCommand command);

    void deleteOrderById(Long orderId);
}


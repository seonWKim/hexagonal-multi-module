package org.example.adapter.order;

import java.util.Iterator;
import java.util.List;

import org.example.domain.order.Order;
import org.example.application.port.in.OrdersOperationPort;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@StepScope
@RequiredArgsConstructor
public class CompletedOrderReader implements ItemReader<Order> {

    private final OrdersOperationPort ordersOperationPort;
    private final int PAGE_SIZE = 1000;
    private Long lastId = 0L;
    private Iterator<Order> iterator;

    @Override
    public Order read() {
        if (iterator != null && iterator.hasNext()) {
            return iterator.next();
        }

        List<Order> orders = ordersOperationPort.findCompletedOrders(lastId, PAGE_SIZE);
        if (orders.isEmpty()) {
            return null;
        } else {
            lastId = orders.get(orders.size() - 1).getId();
        }

        iterator = orders.iterator();
        return iterator.next();
    }
}

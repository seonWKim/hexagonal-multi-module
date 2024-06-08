package org.example.adapter.order;

import org.example.domain.order.CompletedOrderHistory;
import org.example.domain.order.Order;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class CompletedOrderProcessor implements ItemProcessor<Order, CompletedOrderHistory> {

    @Override
    public CompletedOrderHistory process(Order item) throws Exception {
        return new CompletedOrderHistory(item);
    }
}

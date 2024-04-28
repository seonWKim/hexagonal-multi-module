package org.example.batch.order;

import java.util.List;
import java.util.stream.Collectors;

import org.example.domain.order.CompletedOrderHistory;
import org.example.domain.order.OrderService;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@StepScope
@Component
@RequiredArgsConstructor
public class CompletedOrderWriter implements ItemWriter<CompletedOrderHistory> {

    private final OrderService orderService;

    @Override
    public void write(Chunk<? extends CompletedOrderHistory> chunk) {
        final List<CompletedOrderHistory>
                result = chunk.getItems().stream().map(it -> (CompletedOrderHistory) it).toList();
        orderService.saveCompletedOrders(result);
    }
}

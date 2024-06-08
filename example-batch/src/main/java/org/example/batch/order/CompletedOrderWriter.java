package org.example.batch.order;

import java.util.List;

import org.example.application.port.in.command.SaveOrderHistoriesCommand;
import org.example.domain.order.CompletedOrderHistory;
import org.example.application.port.in.OrdersOperationPort;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@StepScope
@Component
@RequiredArgsConstructor
public class CompletedOrderWriter implements ItemWriter<CompletedOrderHistory> {

    private final OrdersOperationPort ordersOperationPort;

    @Override
    public void write(Chunk<? extends CompletedOrderHistory> chunk) {
        final List<CompletedOrderHistory>
                result = chunk.getItems().stream().map(it -> (CompletedOrderHistory) it).toList();
        ordersOperationPort.saveHistories(new SaveOrderHistoriesCommand(result));
    }
}

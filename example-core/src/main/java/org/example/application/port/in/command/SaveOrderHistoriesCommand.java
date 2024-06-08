package org.example.application.port.in.command;

import java.util.List;

import org.example.domain.order.CompletedOrderHistory;

public record SaveOrderHistoriesCommand(List<CompletedOrderHistory> completedOrderHistories) {}

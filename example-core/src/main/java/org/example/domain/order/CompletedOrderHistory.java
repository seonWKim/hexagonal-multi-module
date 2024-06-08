package org.example.domain.order;

import lombok.Getter;

@Getter
public class CompletedOrderHistory {
    private Long id;

    private Long orderId;

    private Long memberId;

    private String name;

    private int price;

    public CompletedOrderHistory(Order order) {
        this.orderId = order.getId();
        this.memberId = order.getMemberId();
        this.name = order.getName();
        this.price = order.getPrice();
    }
}

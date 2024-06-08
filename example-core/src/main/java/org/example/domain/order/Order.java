package org.example.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private Long id;
    private Long memberId;
    private String name;
    private int price;
    private boolean completed;

    public Order(Long memberId, String name, int price) {
        this.memberId = memberId;
        this.name = name;
        this.price = price;
    }

    public void complete() {
        this.completed = true;
    }
}

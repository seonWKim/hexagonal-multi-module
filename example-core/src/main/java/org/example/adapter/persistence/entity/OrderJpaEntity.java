package org.example.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "orders")
@Getter
public class OrderJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    public OrderJpaEntity() {}

    public OrderJpaEntity(Long memberId, String name, int price) {
        this.memberId = memberId;
        this.name = name;
        this.price = price;
    }

    public void complete() {
        this.completed = true;
    }
}

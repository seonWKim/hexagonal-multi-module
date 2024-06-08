package org.example.adapter.persistence.entity.mapper;

import org.example.adapter.persistence.entity.OrderJpaEntity;
import org.example.domain.order.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderJpaEntityMapper {
    public OrderJpaEntity toJpaEntity(Order order) {
        return new OrderJpaEntity(
                order.getMemberId(),
                order.getName(),
                order.getPrice()
        );
    }

    public Order toDomain(OrderJpaEntity orderJpaEntity) {
        return new Order(
                orderJpaEntity.getId(),
                orderJpaEntity.getMemberId(),
                orderJpaEntity.getName(),
                orderJpaEntity.getPrice(),
                orderJpaEntity.isCompleted()
        );
    }
}

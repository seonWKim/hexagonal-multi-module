package org.example.adapter.persistence.jpa;

import java.util.List;

import org.example.adapter.persistence.entity.OrderJpaEntity;
import org.example.domain.order.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderJpaRepository extends JpaRepository<OrderJpaEntity, Long> {
    List<Order> findByMemberId(Long memberId);

    @Query("SELECT o FROM OrderJpaEntity o WHERE o.id > :lastId AND o.completed = true ORDER BY o.id")
    List<Order> findCompletedOrders(Long lastId, Pageable pageable);
}

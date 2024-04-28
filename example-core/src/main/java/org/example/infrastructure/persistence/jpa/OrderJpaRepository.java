package org.example.infrastructure.persistence.jpa;

import java.util.List;

import org.example.domain.order.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
    List<Order> findByMemberId(Long memberId);

    @Query("SELECT o FROM Order o WHERE o.id > :lastId AND o.completed = true ORDER BY o.id")
    List<Order> findCompletedOrders(Long lastId, Pageable pageable);
}

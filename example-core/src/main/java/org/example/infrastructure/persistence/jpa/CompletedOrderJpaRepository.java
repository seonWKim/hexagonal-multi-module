package org.example.infrastructure.persistence.jpa;

import org.example.domain.order.CompletedOrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedOrderJpaRepository extends JpaRepository<CompletedOrderHistory, Long> {
}

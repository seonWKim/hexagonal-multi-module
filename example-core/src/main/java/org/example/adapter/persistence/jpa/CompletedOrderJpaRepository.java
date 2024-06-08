package org.example.adapter.persistence.jpa;

import org.example.adapter.persistence.entity.CompletedOrderHistoryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedOrderJpaRepository extends JpaRepository<CompletedOrderHistoryJpaEntity, Long> {
}

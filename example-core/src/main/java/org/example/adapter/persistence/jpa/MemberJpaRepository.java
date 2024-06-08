package org.example.adapter.persistence.jpa;

import org.example.adapter.persistence.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {
}

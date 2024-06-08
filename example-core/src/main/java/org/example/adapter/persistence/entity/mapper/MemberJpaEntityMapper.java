package org.example.adapter.persistence.entity.mapper;

import org.example.adapter.persistence.entity.MemberJpaEntity;
import org.example.domain.member.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberJpaEntityMapper {

    public MemberJpaEntity toJpaEntity(Member member) {
        return new MemberJpaEntity(
                member.getName(),
                member.getAge()
        );
    }

    public Member toDomain(MemberJpaEntity memberJpaEntity) {
        return new Member(memberJpaEntity.getName(), memberJpaEntity.getAge());
    }
}

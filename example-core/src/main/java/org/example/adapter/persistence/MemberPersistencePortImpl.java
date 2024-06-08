package org.example.adapter.persistence;

import org.example.adapter.persistence.entity.mapper.MemberJpaEntityMapper;
import org.example.adapter.persistence.jpa.MemberJpaRepository;
import org.example.application.port.out.MemberPersistencePort;
import org.example.domain.member.Member;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberPersistencePortImpl implements MemberPersistencePort {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberJpaEntityMapper mapper;

    @Override
    public Long register(Member member) {
        var entity = mapper.toJpaEntity(member);
        return memberJpaRepository.save(entity).getId();
    }

    @Override
    public Member findById(Long id) {
        return mapper.toDomain(memberJpaRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteById(Long id) {
        memberJpaRepository.deleteById(id);
    }
}

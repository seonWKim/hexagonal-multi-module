package org.example.infrastructure.persistence;

import org.example.domain.member.Member;
import org.example.domain.member.MemberRepository;
import org.example.infrastructure.persistence.jpa.MemberJpaRepository;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Long register(Member member) {
        return memberJpaRepository.save(member).getId();
    }

    @Override
    public Member findById(Long id) {
        return memberJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        memberJpaRepository.deleteById(id);
    }
}

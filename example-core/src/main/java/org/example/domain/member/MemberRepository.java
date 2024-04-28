package org.example.domain.member;

public interface MemberRepository {
    Long register(Member member);

    Member findById(Long id);

    void deleteById(Long id);
}

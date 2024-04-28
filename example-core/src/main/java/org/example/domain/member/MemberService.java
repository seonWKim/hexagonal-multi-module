package org.example.domain.member;

public interface MemberService {
    Member findMemberBy(Long memberId);

    Long register(Member member);

    void deleteById(Long memberId);
}

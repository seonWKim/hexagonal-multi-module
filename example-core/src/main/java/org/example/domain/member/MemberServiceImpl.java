package org.example.domain.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = true)
    public Member findMemberBy(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Transactional
    public Long register(Member member) {
        return memberRepository.register(member);
    }

    @Transactional
    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}

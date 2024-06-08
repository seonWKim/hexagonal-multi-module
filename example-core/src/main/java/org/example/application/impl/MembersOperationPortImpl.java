package org.example.application.impl;

import org.example.application.port.in.MembersOperationPort;
import org.example.application.port.in.command.MemberRegisterCommand;
import org.example.domain.member.Member;
import org.example.application.port.out.MemberPersistencePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class MembersOperationPortImpl implements MembersOperationPort {
    private final MemberPersistencePort memberRepository;

    public MembersOperationPortImpl(MemberPersistencePort memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = true)
    public Member findMemberBy(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Transactional
    public Long register(MemberRegisterCommand command) {
        var member = new Member(command.name(), command.age());
        return memberRepository.register(member);
    }

    @Transactional
    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}

package org.example.adapter.port.in.member;

import org.example.application.port.in.command.MemberRegisterCommand;
import org.example.domain.member.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberRegisterCommand mapToCommand(MemberRequest memberRequest) {
        return new MemberRegisterCommand(memberRequest.name(), memberRequest.age());
    }

    public MemberResponse mapToMemberResponse(Member member) {
        return new MemberResponse(member.getName(), member.getAge());
    }
}

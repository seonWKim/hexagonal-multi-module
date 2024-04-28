package org.example.api.member;

import org.example.domain.member.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member mapToMember(MemberRequest memberRequest) {
        final Member member = new Member(memberRequest.name(), memberRequest.age());
        return member;
    }

    public MemberResponse mapToMemberResponse(Member member) {
        return new MemberResponse(member.getName(), member.getAge());
    }
}

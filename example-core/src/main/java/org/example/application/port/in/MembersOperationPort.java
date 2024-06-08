package org.example.application.port.in;

import org.example.application.port.in.command.MemberRegisterCommand;
import org.example.domain.member.Member;

public interface MembersOperationPort {
    Member findMemberBy(Long memberId);

    Long register(MemberRegisterCommand command);

    void deleteById(Long memberId);
}

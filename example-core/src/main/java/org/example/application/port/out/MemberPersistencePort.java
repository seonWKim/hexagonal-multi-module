package org.example.application.port.out;

import org.example.domain.member.Member;

public interface MemberPersistencePort {
    Long register(Member member);

    Member findById(Long id);

    void deleteById(Long id);
}

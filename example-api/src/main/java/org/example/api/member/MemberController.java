package org.example.api.member;

import org.example.domain.member.MemberService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @GetMapping("/members/{memberId}")
    public MemberResponse findMember(@PathVariable Long memberId) {
        return memberMapper.mapToMemberResponse(memberService.findMemberBy(memberId));
    }

    @PostMapping("/members")
    public Long createMember(@RequestBody MemberRequest memberRequest) {
        return memberService.register(memberMapper.mapToMember(memberRequest));
    }

    @DeleteMapping("/members/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteById(memberId);
    }
}

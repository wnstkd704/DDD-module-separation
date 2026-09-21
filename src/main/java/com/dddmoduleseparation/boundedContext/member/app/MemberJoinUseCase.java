package com.dddmoduleseparation.boundedContext.member.app;

import com.dddmoduleseparation.boundedContext.member.domain.Member;
import com.dddmoduleseparation.boundedContext.member.out.MemberRepository;
import com.dddmoduleseparation.global.initData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberJoinUseCase {
    private final MemberRepository memberRepository;

    public RsData<Member> join(String username, String password, String nickname) {
        Member member = memberRepository.save(new Member(username, password, nickname));

        return new RsData<>("201-1", "%d번 회원이 생성되었습니다.".formatted(member.getId()), member);
    }
}

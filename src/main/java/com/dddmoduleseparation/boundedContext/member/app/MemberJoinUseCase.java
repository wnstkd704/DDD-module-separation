package com.dddmoduleseparation.boundedContext.member.app;

import com.dddmoduleseparation.boundedContext.member.domain.Member;
import com.dddmoduleseparation.boundedContext.member.out.MemberRepository;
import com.dddmoduleseparation.global.eventPublisher.EventPublisher;
import com.dddmoduleseparation.global.initData.RsData;
import com.dddmoduleseparation.sharde.member.dto.MemberDto;
import com.dddmoduleseparation.sharde.member.event.MemberJoinedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberJoinUseCase {
    private final MemberRepository memberRepository;
    private final EventPublisher eventPublisher;

    public RsData<Member> join(String username, String password, String nickname) {
        Member member = memberRepository.save(new Member(username, password, nickname));

        eventPublisher.publish(new MemberJoinedEvent(new MemberDto(member)));

        return new RsData<>("201-1", "%d번 회원이 생성되었습니다.".formatted(member.getId()), member);
    }
}

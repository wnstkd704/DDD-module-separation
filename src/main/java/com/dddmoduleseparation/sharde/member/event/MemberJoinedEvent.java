package com.dddmoduleseparation.sharde.member.event;

import com.dddmoduleseparation.sharde.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberJoinedEvent {
    private final MemberDto member;
}
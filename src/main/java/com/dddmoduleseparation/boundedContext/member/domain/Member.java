package com.dddmoduleseparation.boundedContext.member.domain;

import com.dddmoduleseparation.sharde.member.domain.SourceMember;
import com.dddmoduleseparation.sharde.member.dto.MemberDto;
import com.dddmoduleseparation.sharde.member.event.MemberModifiedEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBER_MEMBER")
@Getter
@NoArgsConstructor
public class Member extends SourceMember {
    public Member(String username, String password, String nickname) {
        super(username, password, nickname);
    }

    public int increaseActivityScore(int amount) {
        if (amount == 0) return getActivityScore();

        setActivityScore(getActivityScore() + amount);

        publishEvent(
                new MemberModifiedEvent(new MemberDto(this))
        );
        return getActivityScore();
    }
}

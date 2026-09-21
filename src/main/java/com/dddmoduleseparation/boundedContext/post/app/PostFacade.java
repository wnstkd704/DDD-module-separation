package com.dddmoduleseparation.boundedContext.post.app;

import com.dddmoduleseparation.boundedContext.member.domain.Member;
import com.dddmoduleseparation.boundedContext.post.domain.Post;
import com.dddmoduleseparation.boundedContext.post.domain.PostMember;
import com.dddmoduleseparation.boundedContext.post.out.PostMemberRepository;
import com.dddmoduleseparation.boundedContext.post.out.PostRepository;
import com.dddmoduleseparation.global.initData.RsData;
import com.dddmoduleseparation.sharde.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostRepository postRepository;
    private final PostMemberRepository postMemberRepository;
    private final PostWriteUseCase postWriteUseCase;

    @Transactional(readOnly = true)
    public long count() {
        return postRepository.count();
    }

    @Transactional
    public RsData<Post> write(Member author, String title, String content) {
        return postWriteUseCase.write(author, title, content);
    }

    @Transactional(readOnly = true)
    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    @Transactional
    public PostMember syncMember(MemberDto member) {
        PostMember _member = new PostMember(
                member.getId(),
                member.getCreateDate(),
                member.getModifyDate(),
                member.getUsername(),
                "",
                member.getNickname()
        );

        return postMemberRepository.save(_member);
    }
}
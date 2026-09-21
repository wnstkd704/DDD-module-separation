package com.dddmoduleseparation.boundedContext.post.app;

import com.dddmoduleseparation.boundedContext.member.domain.Member;
import com.dddmoduleseparation.boundedContext.post.domain.Post;
import com.dddmoduleseparation.boundedContext.post.out.PostRepository;
import com.dddmoduleseparation.global.eventPublisher.EventPublisher;
import com.dddmoduleseparation.global.initData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostRepository postRepository;
    private final PostWriteUseCase postJoinUseCase;
    private final EventPublisher eventPublisher;

    @Transactional(readOnly = true)
    public long count() {
        return postRepository.count();
    }

    @Transactional
    public RsData<Post> write(Member author, String title, String content) {
        return postJoinUseCase.write(author, title, content);
    }

    @Transactional(readOnly = true)
    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }
}
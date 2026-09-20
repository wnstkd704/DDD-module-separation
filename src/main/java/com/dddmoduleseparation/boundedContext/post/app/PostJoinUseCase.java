package com.dddmoduleseparation.boundedContext.post.app;

import com.dddmoduleseparation.boundedContext.member.domain.Member;
import com.dddmoduleseparation.boundedContext.post.domain.Post;
import com.dddmoduleseparation.boundedContext.post.out.PostRepository;
import com.dddmoduleseparation.global.eventPublisher.EventPublisher;
import com.dddmoduleseparation.sharde.post.dto.PostDto;
import com.dddmoduleseparation.sharde.post.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostJoinUseCase {
    private final PostRepository postRepository;
    private final EventPublisher eventPublisher;

    public Post write(Member author, String title, String content) {
        Post post = postRepository.save(new Post(author, title, content));

        eventPublisher.publish(
                new PostCreatedEvent(
                        new PostDto(post)
                )
        );
        return post;
    }
}

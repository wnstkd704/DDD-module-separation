package com.dddmoduleseparation.boundedContext.post.app;

import com.dddmoduleseparation.boundedContext.post.domain.Post;
import com.dddmoduleseparation.boundedContext.post.domain.PostMember;
import com.dddmoduleseparation.boundedContext.post.out.PostRepository;
import com.dddmoduleseparation.global.eventPublisher.EventPublisher;
import com.dddmoduleseparation.global.initData.RsData;
import com.dddmoduleseparation.sharde.member.out.MemberApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostWriteUseCase {
    private final PostRepository postRepository;
    private final EventPublisher eventPublisher;
    private final MemberApiClient memberApiClient;

    public RsData<Post> write(PostMember author, String title, String content) {
        Post post = postRepository.save(new Post(author, title, content));
        String randomSecureTip = memberApiClient.getRandomSecureTip();

        return new RsData<>(
                "201-1",
                "%d번 글이 생성되었습니다. 보안 팁 : %s"
                        .formatted(post.getId(), randomSecureTip),
                post
        );
    }
}

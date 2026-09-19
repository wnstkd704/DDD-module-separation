package com.dddmoduleseparation.comment;

import com.dddmoduleseparation.member.Member;
import com.dddmoduleseparation.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public long count() {
        return commentRepository.count();
    }

    public Comment write(Post post, Member author, String content) {
        Comment comment = new Comment(post, author, content);

        return commentRepository.save(comment);
    }

    public List<Comment> findByPost(Post post) {
        return commentRepository.findByPost(post);
    }
}

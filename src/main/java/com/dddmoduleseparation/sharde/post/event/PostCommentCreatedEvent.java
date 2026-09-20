package com.dddmoduleseparation.sharde.post.event;

import com.dddmoduleseparation.sharde.post.dto.PostCommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostCommentCreatedEvent {
    private final PostCommentDto postComment;
}
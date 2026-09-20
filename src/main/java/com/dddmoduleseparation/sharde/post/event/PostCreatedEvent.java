package com.dddmoduleseparation.sharde.post.event;

import com.dddmoduleseparation.sharde.post.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostCreatedEvent {
    private final PostDto post;

}
package com.dddmoduleseparation.comment;

import com.dddmoduleseparation.jpa.entity.BaseIdAndTime;
import com.dddmoduleseparation.member.Member;
import com.dddmoduleseparation.post.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
public class Comment extends BaseIdAndTime {

    @ManyToOne(fetch = LAZY)
    private Post post;

    @ManyToOne(fetch = LAZY)
    private Member author;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    public Comment(Post post, Member author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }
}

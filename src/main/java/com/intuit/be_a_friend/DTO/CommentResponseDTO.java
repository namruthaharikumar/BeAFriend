package com.intuit.be_a_friend.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentResponseDTO {
    private Long postId;
    private String userId;
    private String content;
    private Long parentCommentId;
    private Long commentId;
    private int likes;
    private int dislikes;
}

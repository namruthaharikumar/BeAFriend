package com.intuit.be_a_friend.repositories;

import com.intuit.be_a_friend.entities.Comment;
import com.intuit.be_a_friend.entities.Post;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
        // Fetch top-level comments by post ID (where parentComment is null)
        @Query("SELECT c FROM Comment c WHERE c.post.id = :postId AND c.parentComment IS NULL ORDER BY c.likes DESC, c.dislikes ASC, c.createdAt DESC")
        Page<Comment> findByPostAndParentCommentIsNullOrderByLikesDescAndCreatedDateDesc(@Param("postId") Long postId, Pageable pageable);
        // Fetch replies by parent comment
        @Query("SELECT c FROM Comment c WHERE c.parentComment.id = :parentCommentId ORDER BY c.createdAt ASC")
        Page<Comment> findByParentComment(@Param("parentCommentId") Long parentCommentId, Pageable pageable);

        int countByParentComment(Comment parentComment);

        int countByPostAndParentCommentIsNull(Post post);

        @Query("SELECT c FROM Comment c WHERE c.requestId = :requestId AND c.user.userId = :userId AND c.post.id = :postId")
        Optional<Comment> findByRequestIdAndUserIdAndPostId(@Param("requestId") String requestId, @Param("userId") String userId,@Param("postId") Long postId);
}

package com.intuit.be_a_friend.repositories;

import com.intuit.be_a_friend.entities.Comment;
import com.intuit.be_a_friend.entities.LikeEO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<LikeEO,Long> {
        @Query("SELECT l FROM LikeEO l WHERE l.comment.id = :commentId AND l.isLike = :isTrue")
        Page<LikeEO> findByCommentIdAndLike(@Param("commentId") Long commentId, @Param("isTrue") boolean isTrue, Pageable pageable);

        @Query("SELECT l FROM LikeEO l WHERE l.comment.id = :commentId AND l.user.userId= :userId")
        Optional<LikeEO> findByCommentAndUser(@Param("commentId") Long commentId,@Param("userId") String userId);

        @Query("SELECT l FROM LikeEO l WHERE l.comment.id = :commentId AND l.user.userId= :userId AND l.isLike = :isTrue")
        Optional<LikeEO> findByCommentIdAndUserAndLike(@Param("commentId") Long commentId,@Param("userId") String userId,@Param("isTrue") boolean isTrue);
}

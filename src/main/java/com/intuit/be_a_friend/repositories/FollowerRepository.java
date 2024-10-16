package com.intuit.be_a_friend.repositories;

import com.intuit.be_a_friend.entities.Follower;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {

    @Query("SELECT f.followingId FROM Follower f WHERE f.subscriberId = :subscriberId")
    List<String> findFollowingUsersBySubscriberId(@Param("subscriberId") String subscriberId);

    @Query("SELECT f.followingId FROM Follower f WHERE f.subscriberId = :subscriberId")
    List<String> findFollowingUsersBySubscriberIdWithPagination(@Param("subscriberId") String subscriberId, Pageable page);

    @Query("SELECT f FROM Follower f WHERE f.followingId = :followingId AND f.subscriberId = :subscriberId")
    Follower findByFollowingIdAndSubscriberId(@Param("followingId") String followingId, @Param("subscriberId") String subscriberId);

    @Query("SELECT f.subscriberId FROM Follower f WHERE f.followingId = :followingId")
    List<String> findSubscribers(@Param("followingId") String followingId);


}

package site.dayquestion.Follow.repository;

import site.dayquestion.domain.Follow;

import java.util.List;

public interface FollowRepository {
    Follow findByFollowerIdAndFollowingId(Long followerId, Long followingId);
    List<Follow> findAllByFollowerId(Long followerId);
    List<Follow> findAllByFollowingId(Long followingId);

    Long save(Follow follow);


}

package site.dayquestion.Follow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.dayquestion.domain.Follow;

import java.util.List;


public interface FollowJpaRepository extends JpaRepository<Follow, Long> {

    Follow findByFollowerIdAndFollowingId(Long followerId, Long followingId);

    List<Follow> findAllByFollowerId(Long followerId);

    List<Follow> findAllByFollowingId(Long followingId);

}

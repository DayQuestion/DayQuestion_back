package site.dayquestion.Follow.service;

import site.dayquestion.domain.Follow;
import site.dayquestion.domain.Member;

import java.util.List;

public interface FollowService {
    Long insertFollow(Long followerId, Long followingId);

    Long updateFollowStatus(Long followerId, Long followingId);

    List<Member> getFriendList(Long memberId);

    Follow getFollow(Long followerId, Long followingId);


}

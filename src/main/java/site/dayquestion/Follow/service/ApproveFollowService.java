package site.dayquestion.Follow.service;

import org.springframework.stereotype.Service;
import site.dayquestion.domain.Follow;
import site.dayquestion.domain.Member;

import java.util.List;

@Service
public class ApproveFollowService implements FollowService {

    @Override
    public Long insertFollow(Long followerId, Long followingId) {
        return null;
    }

    @Override
    public Long updateFollowStatus(Long followerId, Long followingId) {
        return null;
    }

    @Override
    public List<Member> getFriendList(Long memberId) {
        return null;
    }

    @Override
    public Follow getFollow(Long followerId, Long followingId) {
        return null;
    }
}

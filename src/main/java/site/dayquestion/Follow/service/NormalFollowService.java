package site.dayquestion.Follow.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Enum.Status;
import site.dayquestion.Follow.repository.FollowRepository;
import site.dayquestion.Follow.repository.MemberRepository;
import site.dayquestion.domain.Follow;
import site.dayquestion.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@Transactional
@RequiredArgsConstructor
public class NormalFollowService implements FollowService {
    private final FollowRepository followRepository;
    private final MemberRepository memberRepository;

    @Override
    public Long insertFollow(Long followerId, Long followingId) {
        Optional<Member> followerMember = memberRepository.findById(followerId);
        Optional<Member> followingMember = memberRepository.findById(followingId);

        // validation
        if (followerMember.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        if (followingMember.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 회원에 대한 팔로우 요청입니다.");
        }
        if (followRepository.findByFollowerIdAndFollowingId(followerId, followingId) != null) {
            throw new IllegalArgumentException("이미 팔로우하고 있습니다.");
        }

        Follow follow = Follow.builder()
                .follower(followerMember.get())
                .following(followingMember.get()).build();

        Follow savedFollow = followRepository.save(follow);

        return savedFollow.getId();

    }

    @Override
    public Long updateFollowStatus(Long followerId, Long followingId) {
        Follow findFollow = followRepository.findByFollowerIdAndFollowingId(followerId, followingId);

        // validation
        if (findFollow == null) {
            throw new IllegalArgumentException("팔로우하지 않고 있습니다.");
        }


        findFollow.changeStatus(Status.DELETED);

        return findFollow.getId();
    }

    @Override
    public Follow getFollow(Long followerId, Long followingId) {
        return followRepository.findByFollowerIdAndFollowingId(followerId, followingId);

    }

    @Override
    public List<Member> getFriendList(Long memberId) {
        List<Follow> foundFollowList = followRepository.findAllByFollowerId(memberId);
        ArrayList<Member> friends = new ArrayList();
        foundFollowList.forEach(follow -> friends.add(follow.getFollowing()));
        return friends;
    }




}

package site.dayquestion.Follow;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.dayquestion.Follow.Dto.FollowResDto;
import site.dayquestion.Follow.Dto.FollowReqDto;
import site.dayquestion.Follow.service.FollowService;
import site.dayquestion.domain.Member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;

    @PostMapping("/api/follows")
    public Long followMember(@RequestBody FollowReqDto request) {
        Long savedFollowId = followService.insertFollow(request.getFollowerId(), request.getFollowingId());
        return savedFollowId;
    }

    @DeleteMapping("/api/follows")
    public Long unfollowMember(@RequestBody FollowReqDto request) {
        Long savedFollowId = followService.updateFollowStatus(request.getFollowerId(), request.getFollowingId());
        return savedFollowId;
    }

    @GetMapping("/api/members/{member-id}/follows")
    public List<FollowResDto> getFriendList(@PathVariable("member-id") Long memberId) {
        List<Member> friendList = followService.getFriendList(memberId);

        ArrayList<FollowResDto> followResDtoList = new ArrayList();
        friendList.forEach(friend ->
            {
                FollowResDto followResDto = new FollowResDto(friend.getId(), friend.getNickname(), friend.getProfileImageUrl());
                followResDtoList.add(followResDto);
            });

        return followResDtoList;
    }
}

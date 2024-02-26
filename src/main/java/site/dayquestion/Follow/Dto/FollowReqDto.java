package site.dayquestion.Follow.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class FollowReqDto {
    private Long followerId;
    private Long followingId;
}

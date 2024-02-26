package site.dayquestion.Follow.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class FollowResDto {
    private Long memberId;
    private String nickname;
    private String profileImage;
//    private LocalDate lastUpdatedDate; // Answer 메서드가 필요해서 보류
}

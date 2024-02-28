package site.dayquestion.Auth.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberReqDto {
    private String email;
    private String password;
    private String nickname;
}

package site.dayquestion.MyAuth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberReqDto {
    private String email;
    private String password;
    private String nickname;
}

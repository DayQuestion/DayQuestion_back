package site.dayquestion.Auth.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginReqDto {
    private String email;
    private String password;
}

package site.dayquestion.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.dayquestion.Auth.DTO.LoginReqDto;
import site.dayquestion.Auth.DTO.MemberReqDto;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/api/auth/register")
    public Long join(@RequestBody MemberReqDto memberReqDto) {
        return authService.join(memberReqDto);
    }

    @PostMapping("/api/auth/login")
    public Long login(@RequestBody LoginReqDto loginReqDto) {
        Long loginMemberId = authService.login(loginReqDto);
        return loginMemberId;
    }
}

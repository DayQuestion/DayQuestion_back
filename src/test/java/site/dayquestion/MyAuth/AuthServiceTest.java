package site.dayquestion.MyAuth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.MyAuth.dto.LoginReqDto;
import site.dayquestion.MyAuth.dto.MemberReqDto;


@SpringBootTest
class AuthServiceTest {

    @Autowired private AuthService authService;

    @Test
    @Transactional
    public void joinTest() {
        // given
        MemberReqDto memberReqDto = new MemberReqDto("test@email.com", "myPw", "minimmini");
        Long memberId = authService.join(memberReqDto);

        // then
        System.out.println("memberId = " + memberId);
    }

    @Test
    public void loginTest() {
        // given
        MemberReqDto memberReqDto = new MemberReqDto("test@email.com", "myPw", "minimmini");
        Long memberId = authService.join(memberReqDto);

        LoginReqDto loginReqDto = new LoginReqDto("test@email.com", "myPw");
        Long loginMemberId = authService.login(loginReqDto);

        // when
        Assertions.assertThat(memberId).isEqualTo(loginMemberId);

        // then

    }

}
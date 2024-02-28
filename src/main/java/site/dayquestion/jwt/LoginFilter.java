package site.dayquestion.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StreamUtils;
import site.dayquestion.Auth.DTO.LoginReqDto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    public LoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
        System.out.println("비밀번호 제대로 들어왓나?: " + request.getParameter("password"));
        System.out.println("이메일 제대로 들어왓나?: " + request.getParameter("email"));
        LoginReqDto loginDTO;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ServletInputStream inputStream = request.getInputStream();
            String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
            loginDTO = objectMapper.readValue(messageBody, LoginReqDto.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

//        String password = obtainPassword(request);
//        String email = request.getParameter("email");

        System.out.println("비밀번호 제대로 들어왓나?: " + password);
        System.out.println("이메일 제대로 들어왓나?: " + email);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, password, null);

        //토큰 건네면 authenticationManager가 토큰값 검증
        return authenticationManager.authenticate(authToken);
    }

    //로그인 성공시 실행하는 메소드 (여기서 JWT를 발급하면 됨)
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) {
//
//    }
//    //로그인 실패시 실행하는 메소드
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
//
//    }
}

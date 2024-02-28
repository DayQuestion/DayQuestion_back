package site.dayquestion;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import site.dayquestion.MyAuth.jwt.JwtFilter;
import site.dayquestion.MyAuth.jwt.JwtUtil;
import site.dayquestion.MyAuth.jwt.LoginFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity // 시큐리티 설정 파일이라는 의미
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtUtil jwtUtil;
    //AuthenticationManager Bean 등록
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(auth -> auth.disable())
                .formLogin(auth -> auth.disable())
                .httpBasic(auth -> auth.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login","/api/auth", "/", "/auth").permitAll() // /auth는 모든 권한 허용
                        .requestMatchers("/admin").hasRole("ADMIN") // /admin는 ADMIN만 접근 가능
                        .anyRequest().authenticated()); // 나머지 요청은 로그인한 사용자만 접근 가능

        http
                .addFilterBefore(new JwtFilter(jwtUtil), LoginFilter.class);

        http
                .sessionManagement(session -> session
                        .sessionCreationPolicy((SessionCreationPolicy.STATELESS))); // JWT에서는 항상 stateless 상태를 만들어줘야 함

        http
                .addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
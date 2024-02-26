package site.dayquestion.MyAuth;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Enum.LoginType;
import site.dayquestion.Follow.repository.MemberRepository;
import site.dayquestion.domain.Member;

@Transactional
@Service
@AllArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public Long join (MemberReqDto memberReqDto) {
        // 이메일 중복 검사
        Member memberFoundByEmail = memberRepository.findByEmail(memberReqDto.getEmail());

        if (memberFoundByEmail != null) {
            throw new IllegalArgumentException("이미 등록된 이메일 주소입니다.");
        }

        // 비밀번호 암호화
        String rawPw = memberReqDto.getPassword();
        String encodedPw = passwordEncoder.encode(rawPw);

        Member newMember = Member.builder()
                .nickname(memberReqDto.getNickname())
                .email(memberReqDto.getEmail())
                .password(encodedPw)
                .loginType(LoginType.NORMAL)
                .build();

        Long savedMemberId = memberRepository.save(newMember);
        return savedMemberId;

    }

    public Long login(LoginReqDto loginReqDto) {
        Member memberFoundByEmail = memberRepository.findByEmail(loginReqDto.getEmail());

        if(passwordEncoder.matches(loginReqDto.getPassword(), memberFoundByEmail.getPassword())) {
            return memberFoundByEmail.getId();
        } else {
            return null;
        }

    }
}

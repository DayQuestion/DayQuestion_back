package site.dayquestion.Auth;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Member.repository.MemberRepository;
import site.dayquestion.Auth.DTO.LoginReqDto;
import site.dayquestion.Auth.DTO.MemberReqDto;
import site.dayquestion.domain.Member;

@Transactional
@Service
@AllArgsConstructor
public class AuthService {
    private final MemberRepository memRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    public Long join (MemberReqDto memberReqDto) {
        //중복 검사
        Member memberFoundByEmail = memRepo.findByEmail(memberReqDto.getEmail());
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
                .build();

        Long savedMemberId = memRepo.save(newMember);
        return savedMemberId;

    }

    public Long login(LoginReqDto loginReqDto) {
        Member memberFoundByEmail = memRepo.findByEmail(loginReqDto.getEmail());

        if(passwordEncoder.matches(loginReqDto.getPassword(), memberFoundByEmail.getPassword())) {
            return memberFoundByEmail.getId();
        } else {
            return null;
        }

    }
}

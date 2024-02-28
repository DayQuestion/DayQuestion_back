package site.dayquestion.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import site.dayquestion.Member.repository.MemberRepository;
import site.dayquestion.Auth.DTO.CustomUserDetails;
import site.dayquestion.domain.Member;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //DB에서 조회
        Member member = memRepo.findByEmail(email);
        if (member != null) {
            //UserDetails에 담아서 return하면 AutneticationManager가 검증 함
            return new CustomUserDetails(member);
        }

        return null;
    }
}
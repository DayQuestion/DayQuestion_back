package site.dayquestion.Auth.DTO;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import site.dayquestion.domain.Member;

import java.util.Collection;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final Member membaer;

    //role: 관리자 권한같은거 만들때 필요한듯
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
//        Collection<GrantedAuthority> collection = new ArrayList<>();
//
//        collection.add(new GrantedAuthority() {
//
//            @Override
//            public String getAuthority() {
//
//                return membaer.getStatus().toString();
//            }
//        });
//
//        return collection;
    }

    @Override
    public String getPassword() {

        return membaer.getPassword();
    }

    @Override
    public String getUsername() {

        return membaer.getNickname();
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }
}

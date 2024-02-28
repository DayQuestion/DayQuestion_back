package site.dayquestion.domain;
import jakarta.persistence.*;
import lombok.*;
import site.dayquestion.Enum.LoginType;

import static site.dayquestion.Enum.LoginType.NORMAL;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Member extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String email;
    private String nickname;
    @Builder.Default
    private String introduce = "안녕하세요.";
    private String password;
    @Builder.Default
    private String profileImageUrl = "https://ibb.co/nsmT8qq"; //메이플머리이미지
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private LoginType loginType = NORMAL;

    public void editProfile(Long id, String newNickname, String newIntroduce, String newPassword, String newProfileImageUrl){
        this.nickname = newNickname;
        this.introduce = newIntroduce;
        this.password = newPassword;
        this.profileImageUrl = newProfileImageUrl;
    }

}


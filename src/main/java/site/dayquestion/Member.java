package site.dayquestion;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import site.dayquestion.Enum.LoginType;

@Entity
@Getter
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String nickname;
    private String introduce;
    private String password;

    @Lob
    private String profileImage;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    public void changeNickname(String newNickname) {
        this.nickname = newNickname;
    }

    public void changeIntroduce (String newIntroduce) {
        this.introduce = newIntroduce;
    }

    public void changeEmail(String newEmail) {
        // validationEmailRegex(newEmail);
        this.email = newEmail;
    }

    public void changePassword(String newPw) {
        this.password = newPw;
    }

    public void changeProfileIamge(String newProfileImageUrl) {
        this.profileImage = newProfileImageUrl;
    }
}

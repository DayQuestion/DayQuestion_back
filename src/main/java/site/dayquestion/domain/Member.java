package site.dayquestion.domain;


import jakarta.persistence.*;
import lombok.*;
import site.dayquestion.Enum.LoginType;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String nickname;
    @Builder.Default
    private String introduce = "안녕하세요!";
    private String password;
    @Builder.Default
    private String profileImageUrl = "https://m.blog.naver.com/gambasg/222132751279?view=img_12";

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

}


package site.dayquestion.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import site.dayquestion.Enum.LoginType;

@Entity
@Getter
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String nickname;
    private String introduce;
    private String password;
    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

}


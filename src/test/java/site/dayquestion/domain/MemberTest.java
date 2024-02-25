package site.dayquestion.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import site.dayquestion.Enum.Status;

import static site.dayquestion.Enum.Status.ACTIVE;

class MemberTest {

    @Test
    public void builder테스트(){
        Member member = Member.builder()
                .id(132L)
                .email("이메일")
                .nickname("닉네임")
                .password("패스워드")
                .build();

        Status status = member.getStatus();
        Assertions.assertThat(status).isEqualTo(ACTIVE);

        Assertions.assertThat(member.getNickname()).isEqualTo("닉네임");
        Assertions.assertThat(member.getIntroduce()).isEqualTo("안녕하세요.");

    }

    @Test
    public void 프로필업데이트_테스트(){
        Member member = Member.builder()
                .id(132L)
                .email("이메일")
                .nickname("닉네임")
                .password("패스워드")
                .build();
        member.editProfile(member.getId(), "닉네임", "자기소개", "패스워드", "String newProfileImageUrl");
        Assertions.assertThat(member.getProfileImageUrl()).isEqualTo("String newProfileImageUrl");
    }
}
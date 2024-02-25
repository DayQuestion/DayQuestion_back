package site.dayquestion.Member.service;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Member.repository.MemberRepository;
import site.dayquestion.domain.Member;

import java.util.List;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired MemberService memSer;
    @Autowired MemberRepository memRep;
    @Autowired EntityManager em;

    @Test
    void 회원프로필수정테스트() {
        Member member = Member.builder()
                .nickname("멤버1")
                .email("wedwedw@wer3.com")
                .password("1234").build();
        Long saveId = memRep.save(member);

        Member newMem = memSer.update(member.getId(), "닉네임2", "소개소개", "패스워드22", "프로필이미지222");
        String newNickname = memSer.findOne(saveId).getNickname();
        Assertions.assertThat(newNickname).isEqualTo(newMem.getNickname());

    }
    @Test
    void 회원다건조회테스트() {
        Member member1 = Member.builder()
                .nickname("멤버1")
                .email("wedwedw@wer3.com")
                .password("1234").build();
        Member member2 = Member.builder()
                .nickname("멤버2")
                .email("wedwedw@wer3.com")
                .password("1234").build();
        Member member3 = Member.builder()
                .nickname("멤버3")
                .email("wedwedw@wer3.com")
                .password("1234").build();
        Member member4 = Member.builder()
                .nickname("멤버4")
                .email("wedwedw@wer3.com")
                .password("1234").build();
        Member member5 = Member.builder()
                .nickname("멤버5")
                .email("wedwedw@wer3.com")
                .password("1234").build();
        memSer.join(member1);
        memSer.join(member2);
        memSer.join(member3);
        memSer.join(member4);
        memSer.join(member5);

        List<Member> memberList = memSer.findMemList(3);
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(memberList.get(i).getNickname());
        }
    }
    @Test
    public void 프로필업데이트_테스트(){
        Member member = memSer.findOne(1L);
        memSer.update(member.getId(), "닉네임", "자기소개", "패스워드", "String newProfileImageUrl");
        Assertions.assertThat(member.getProfileImageUrl()).isEqualTo("String newProfileImageUrl");
    }
}
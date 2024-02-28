package site.dayquestion.Member.service;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Member.repository.MemberRepository;
import site.dayquestion.Auth.AuthService;
import site.dayquestion.Auth.DTO.MemberReqDto;
import site.dayquestion.domain.Member;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberServiceTest {
    @Autowired MemberService memSer;
    @Autowired
    AuthService authSer;
    @Autowired MemberRepository memRepo;
    @Autowired EntityManager em;

    @Test
    void 회원프로필수정테스트() {
        Member member = Member.builder()
                .nickname("멤버1")
                .email("wedwedw@wer3.com")
                .password("1234").build();
        Long saveId = memRepo.save(member);

        Member newMem = memSer.update(member.getId(), "닉네임2", "소개소개", "패스워드22", "프로필이미지222");
        String newNickname = memSer.findOne(saveId).getNickname();
        Assertions.assertThat(newNickname).isEqualTo(newMem.getNickname());

    }
    @Test
    void 회원다건조회테스트() {
        MemberReqDto member1 = MemberReqDto.builder()
                .nickname("멤버1")
                .email("1111@1.com")
                .password("1111").build();
        MemberReqDto member2 = MemberReqDto.builder()
                .nickname("멤버2")
                .email("2222@2.com")
                .password("2222").build();
        MemberReqDto member3 = MemberReqDto.builder()
                .nickname("멤버3")
                .email("3333@3.com")
                .password("3333").build();
        MemberReqDto member4 = MemberReqDto.builder()
                .nickname("멤버4")
                .email("4444@4.com")
                .password("4444").build();

        authSer.join(member1);
        authSer.join(member2);
        authSer.join(member3);
        authSer.join(member4);

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
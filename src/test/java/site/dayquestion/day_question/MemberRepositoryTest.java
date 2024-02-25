package site.dayquestion.day_question;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.domain.Member;
import site.dayquestion.Member.repository.MemberRepository;
import java.util.List;


@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memRep;

    @Test
    @Transactional
    public void 회원가입_및_찾기_테스트(){
        Member member = Member.builder()
                .nickname("멤버1")
                .email("wedwedw@wer3.com")
                .password("1234").build();

        Long saveId = memRep.save(member);
        Member findMember = memRep.findMemberById(saveId);

        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getNickname()).isEqualTo(member.getNickname());

    }
    @Test
    @Transactional
    public void 랜덤회원3명_찾기_테스트(){
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
        memRep.save(member1);
        memRep.save(member2);
        memRep.save(member3);
        memRep.save(member4);
        memRep.save(member5);

        List<Member> memberList = memRep.findMemberList(3);
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(memberList.get(i).getNickname());
        }

    }

}
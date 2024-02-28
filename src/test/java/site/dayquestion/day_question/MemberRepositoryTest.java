package site.dayquestion.day_question;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Follow.repository.MemberRepository;
import site.dayquestion.domain.Member;

import java.util.Optional;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {


    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception {
        //given: 이런게 주어졌을떄
        Member member = new Member();
//        member.setNickname("memberA");

        //when: 이렇게하면 (테스트 하고싶은 내용)
        Member savedMember = memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findById(savedMember.getId());

        //then: 이렇게된다 검증해라
        Assertions.assertThat(findMember.get().getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.get().getNickname()).isEqualTo(member.getNickname());

    }


}
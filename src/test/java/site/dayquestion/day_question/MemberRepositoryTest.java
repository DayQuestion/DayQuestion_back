package site.dayquestion.day_question;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
<<<<<<< HEAD
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Follow.repository.MemberRepository;
import site.dayquestion.domain.Member;

import java.util.Optional;
=======
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.domain.Member;
import site.dayquestion.repository.MemberRepository;
>>>>>>> main

//@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {


    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
<<<<<<< HEAD
    @Rollback(false)
=======
>>>>>>> main
    public void testMember() throws Exception {
        //given: 이런게 주어졌을떄
        Member member = new Member();
//        member.setNickname("memberA");

        //when: 이렇게하면 (테스트 하고싶은 내용)
<<<<<<< HEAD
        Member savedMember = memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findById(savedMember.getId());

        //then: 이렇게된다 검증해라
        Assertions.assertThat(findMember.get().getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.get().getNickname()).isEqualTo(member.getNickname());
=======
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then: 이렇게된다 검증해라
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getNickname()).isEqualTo(member.getNickname());
>>>>>>> main

    }


}
package site.dayquestion;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    @Transactional
    @Rollback(false) // 자동 롤백 끔
    public void testMember() {
        // given
        Member member = new Member();
        member.changeNickname("mini");

        // when
        Long saveId = memberRepository.save(member);
        Member findMember = em.find(Member.class, saveId);

        System.out.println("findMember.getNickname() = " + findMember.getNickname());

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember).isEqualTo(member);
        // 저장한 객체 == 읽어온 객체???



    }
}
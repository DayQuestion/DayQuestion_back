package site.dayquestion.Follow;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Enum.Status;
import site.dayquestion.Follow.repository.MemberRepository;
import site.dayquestion.Follow.service.FollowService;
import site.dayquestion.domain.Follow;
import site.dayquestion.domain.Member;

@SpringBootTest
@Transactional
@Rollback(value = false)
class NormalFollowServiceTest {
    @Autowired private MemberRepository memberRepository;
    @Autowired private FollowService followService;
    @Autowired private EntityManager em;

//    @Test
//    public void followMemberTest() {
//        // given
//        Member memberA = new Member();
//        Member memberB = new Member();
//        Long savedMemberAId = memberRepository.save(memberA);
//        Long savedMemberBId = memberRepository.save(memberB);
//
//        // when
//        Long followId = followService.insertFollow(savedMemberAId, savedMemberBId);
//
//        // then
//        System.out.println("followId = " + followId);
//
//    }
//
//    @Test
//    public void deleteFollowTest () {
//        Member memberC = new Member();
//        Member memberD = new Member();
//        Long member1Id = memberRepository.save(memberC);
//        Long member2Id = memberRepository.save(memberD);
//
//        Long followId = followService.insertFollow(member1Id, member2Id);
//
//        System.out.println("followId = " + followId);
//
//        // when
//        followService.updateFollowStatus(member1Id, member2Id);
//
//        Follow foundFollow = followService.getFollow(member1Id, member2Id);
//        Assertions.assertThat(foundFollow.getStatus()).isEqualTo(Status.DELETED);
//
//
//    }

}
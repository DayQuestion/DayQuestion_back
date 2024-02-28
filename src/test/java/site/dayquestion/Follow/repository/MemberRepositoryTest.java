package site.dayquestion.Follow.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.dayquestion.domain.Member;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;

    @Test
    public void findByEmailTest() {
        // given
        Optional<Member> foundMemberByEmail = memberRepository.findByEmail("test@email.com");
        System.out.println("foundMemberByEmail.getId() = " + foundMemberByEmail.get().getId());

        // when


        // then

    }

}
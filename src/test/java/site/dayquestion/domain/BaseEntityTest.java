package site.dayquestion.domain;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class BaseEntityTest {

    @Autowired private EntityManager em;

//    @Test
//    public void 생성수정일시_Test() {
//        // given
//        Member mini = Member.builder()
//                .nickname("민희")
//                .email("radic7700@gmail.com")
//                .introduce("뭘봐!")
//                .build();
//
//        // when
//        em.persist(mini);
//        em.flush();
//        em.clear();
//
//        // then
//        Member memberMini = em.find(Member.class, mini);
//        System.out.println("memberMini.getCreatedAt() = " + memberMini.getCreatedAt());
//    }

}
package site.dayquestion.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import site.dayquestion.domain.Member;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;


    //저장 메서드
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    //찾는 메서드
    public Member find(Long id) {
        return em.find(Member.class, id);
    }




}

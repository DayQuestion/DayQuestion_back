package site.dayquestion.Member.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.dayquestion.domain.Member;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    //회원 저장 메서드
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    //회원 한명 조회 메서드
    public Member findMemberById(Long id) {
        return em.find(Member.class, id);
    }

    //랜덤 회원 목록 조회: 3명만
     public List<Member> findMemberList(int limit){
        TypedQuery<Member> query = em.createQuery(
                "SELECT m FROM Member m ORDER BY RANDOM()", Member.class);
        query.setMaxResults(limit);
        return query.getResultList();
    }

}

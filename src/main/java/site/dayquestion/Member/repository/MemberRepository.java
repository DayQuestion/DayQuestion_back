package site.dayquestion.Member.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.dayquestion.domain.Member;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;
    //가입
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    //조회
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }
    public Member findByEmail (String email) {
        try {
            Member foundMember = em.createQuery("select m from Member m where email =:email", Member.class)
                    .setParameter("email", email)
                    .getSingleResult();
            return foundMember;
        } catch (NoResultException ne) {
            return null;
        }
    }
     public List<Member> findList(int limit){
        TypedQuery<Member> query = em.createQuery(
                "SELECT m FROM Member m ORDER BY RANDOM()", Member.class);
        query.setMaxResults(limit);
        return query.getResultList();
    }

}

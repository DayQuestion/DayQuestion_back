package site.dayquestion.Follow.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.domain.Member;

@Repository
@Transactional
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    // 저장 메서드
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    // 찾는 메서드
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





}

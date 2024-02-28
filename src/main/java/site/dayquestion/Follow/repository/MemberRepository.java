package site.dayquestion.Follow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.dayquestion.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long memberId);

    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);
}

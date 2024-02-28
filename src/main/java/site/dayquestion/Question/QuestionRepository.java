package site.dayquestion.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import site.dayquestion.domain.Question;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByMonthAndDay(int month, int day);
}

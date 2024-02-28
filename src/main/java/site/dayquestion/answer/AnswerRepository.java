package site.dayquestion.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import site.dayquestion.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}

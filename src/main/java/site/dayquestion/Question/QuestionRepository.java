package site.dayquestion.Question;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Enum.Status;
import site.dayquestion.domain.Question;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final EntityManager em;

    public Question find(int month, int day) {
        String query = "select q from Question q where month = :month and day =:day and status <> :status";
        Question foundQuestion = em.createQuery(query, Question.class)
                    .setParameter("month", month)
                    .setParameter("day", day)
                    .setParameter("status", Status.DELETED)
                    .getSingleResult();

        return foundQuestion;

    }

    @Transactional
    public Long save(int month, int day, String content) {
        Question question = Question.builder()
                .month(month)
                .day(day)
                .content(content)
                .build();
        em.persist(question);
        em.flush();

        return question.getId();
    }
}

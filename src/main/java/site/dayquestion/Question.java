package site.dayquestion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Question extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private Long id;
    private String content;

    @Column(name = "question_month")
    private int month;

    @Column(name = "question_day")
    private int day;

    public void changeContent(String newContent) {
        this.content = newContent;
    }

    public void changeMonth(int newMonth) {
        this.month = newMonth;
    }

    public void changeDay(int newDay) {
        this.day = newDay;
    }
}

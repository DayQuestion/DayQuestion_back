package site.dayquestion.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    private String content;
    @Column(name = "question_month")
    private int month;
    @Column(name = "question_day")
    private int day;

//    @Builder
//    public Question(Long id, String content, int month, int day) {
//        this.id = id;
//        this.content = content;
//        this.month = month;
//        this.day = day;
//    }
}

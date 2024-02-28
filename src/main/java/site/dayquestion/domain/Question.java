package site.dayquestion.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
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

}

package site.dayquestion.domain;

import jakarta.persistence.*;
import lombok.Getter;
import site.dayquestion.Enum.PublicStatus;


@Entity
@Getter
public class Answer extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "answer_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writtenBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    private String content;

    @Enumerated(EnumType.STRING)
    private PublicStatus publicStatus;

    //업데이트 날짜는 BaseEntity로 연결합니다.
}

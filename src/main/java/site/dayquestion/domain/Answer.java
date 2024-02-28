package site.dayquestion.domain;

import jakarta.persistence.*;
import lombok.*;
import site.dayquestion.Enum.PublicStatus;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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

    public void changeContent(String content) {
        this.content = content;
    }
//    private LocalDate createYMD;

    //업데이트 날짜는 BaseEntity로 연결합니다.
}

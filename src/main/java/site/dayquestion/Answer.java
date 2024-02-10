package site.dayquestion;

import jakarta.persistence.*;
import lombok.Getter;
import site.dayquestion.Enum.PublicStatus;

import java.time.LocalDate;

@Entity
@Getter
public class Answer {
    @Id
    @GeneratedValue
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

    private LocalDate createdYMD;

    public void changeContent(String newContent) {
        this.content = newContent;
    }

    public void changePublicStatus (PublicStatus newPS) {
        this.publicStatus = newPS;
    }
}

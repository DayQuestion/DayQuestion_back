package site.dayquestion.Question;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuestionRequestDto {
    private Long questionId;
    private String content;

}

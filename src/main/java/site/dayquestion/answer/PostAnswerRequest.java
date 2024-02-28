package site.dayquestion.answer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostAnswerRequest {
    private String content;
    private Long questionId;
    private Long memberId;
}

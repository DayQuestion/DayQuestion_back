package site.dayquestion.Question;

import lombok.Data;

@Data
public class PostQuestionReqDto {
    private int month;
    private int day;
    private String content;
}

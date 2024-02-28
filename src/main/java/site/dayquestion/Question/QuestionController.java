package site.dayquestion.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.dayquestion.domain.Question;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionRepository questionRepository;
    @GetMapping("/api/questions")
    public QuestionRequestDto getQuestion (@RequestParam int month, @RequestParam int day) {

        Optional<Question> question = questionRepository.findByMonthAndDay(month, day);

        if(question.isPresent()) {
            QuestionRequestDto questionRequestDto = QuestionRequestDto.builder()
                    .questionId(question.get().getId())
                    .content(question.get().getContent())
                    .build();
            return questionRequestDto;
        }
        return null;
    }

    @PostMapping("/admin/questions")
    public Long postQuestion(@RequestBody PostQuestionReqDto postQuestionReqDto) {
        int month = postQuestionReqDto.getMonth();
        int day = postQuestionReqDto.getDay();
        String content = postQuestionReqDto.getContent();

        Question question = Question.builder()
                .month(month)
                .day(day)
                .content(content)
                .build();
        Question savedQuestion = questionRepository.save(question);
        return savedQuestion.getId();
    }
}

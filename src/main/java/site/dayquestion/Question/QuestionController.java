package site.dayquestion.Question;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.dayquestion.domain.Question;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionRepository questionRepository;
    @GetMapping("/api/questions")
    public QuestionRequestDto getQuestion (@RequestParam int month, @RequestParam int day) {

        Question question = questionRepository.find(month, day);
        QuestionRequestDto questionRequestDto = QuestionRequestDto.builder()
                .questionId(question.getId())
                .content(question.getContent())
                .build();
        return questionRequestDto;
    }

    @PostMapping("/admin/questions")
    public Long postQuestion(@RequestBody PostQuestionReqDto postQuestionReqDto) {
        Long savedId = questionRepository.save(postQuestionReqDto.getMonth(), postQuestionReqDto.getDay(), postQuestionReqDto.getContent());
        return savedId;
    }
}

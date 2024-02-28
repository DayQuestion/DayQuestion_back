package site.dayquestion.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class controller {
    private final AnswerService answerService;
    @PostMapping("/api/answers")
    public Long postAnswer(@RequestBody PostAnswerRequest request) throws IllegalArgumentException{
        Long answerId = answerService.insertAnswer(request);
        return answerId;
    }

    @PostMapping("/api/answers/{answerId}")
    public Long patchAnswer(@PathVariable("answerId") Long answerId,
                            @RequestBody PatchAnswerRequest request) {
        Long newAnswerId = answerService.updateAnswer(answerId, request);
        return newAnswerId;
    }
}

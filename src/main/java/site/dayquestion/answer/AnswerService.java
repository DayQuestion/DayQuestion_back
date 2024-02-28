package site.dayquestion.answer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.dayquestion.Follow.repository.MemberRepository;
import site.dayquestion.Question.QuestionRepository;
import site.dayquestion.domain.Answer;
import site.dayquestion.domain.Member;
import site.dayquestion.domain.Question;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerService {
    private final QuestionRepository questionRepository;
    private final MemberRepository memberRepository;
    private final AnswerRepository answerRepository;

    public Long insertAnswer(PostAnswerRequest request) {
        String content = request.getContent();
        Long questionId = request.getQuestionId();
        Long memberId = request.getMemberId();

        Optional<Question> question = questionRepository.findById(questionId);
        // validation(유효성 검증) : 유효하지 않은 질문 id입니다.
        if (question == null) {
            throw new IllegalArgumentException();
        }

        // member 검증 : 존재하는 회원인지?
        Optional<Member> member = memberRepository.findById(memberId);

        Answer answer = Answer.builder()
                .content(content)
                .question(question.get())
                .writtenBy(member.get())
                .build();

        Answer savedAnswer = answerRepository.save(answer);
        return savedAnswer.getId();

    }

    public Long updateAnswer(Long answerId, PatchAnswerRequest request) {
        Optional<Answer> answer = answerRepository.findById(answerId);
        answer.get().changeContent(request.getContent()); // 변경 감지?
//        answerRepository.save(answer.get());

        return answerId;
    }
}

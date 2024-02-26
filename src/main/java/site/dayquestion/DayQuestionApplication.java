package site.dayquestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import site.dayquestion.Follow.repository.MemberRepository;
import site.dayquestion.domain.Member;

@SpringBootApplication
@EnableJpaAuditing
public class DayQuestionApplication {
	public static void main(String[] args) {
		SpringApplication.run(DayQuestionApplication.class, args);

	}

}

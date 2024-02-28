package site.dayquestion;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DayQuestionApplication {
	public static void main(String[] args) {
		SpringApplication.run(DayQuestionApplication.class, args);
	}

}

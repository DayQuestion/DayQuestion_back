package site.dayquestion.answer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    private boolean isSuccess;
    private int resultCode;
    private T result;
}

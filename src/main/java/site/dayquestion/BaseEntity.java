package site.dayquestion;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import site.dayquestion.Enum.BaseStatus;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
// @Getter : BaseEntity에도 게터가 필요한가?
public class BaseEntity {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private BaseStatus status;

}

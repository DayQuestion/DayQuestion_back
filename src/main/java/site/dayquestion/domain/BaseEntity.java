package site.dayquestion.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import site.dayquestion.Enum.Status;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false) // 생성일시 컬럼은 수정하지 못하게
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
//    @Builder.Default()
    @ColumnDefault("ACTIVE") // 쿼리 매핑 시점에 설정됨
    private Status status;

    @PrePersist //
    public void prePersist() {
        // 기본값을 설정합니다.
        if (status == null) {
            this.status = Status.ACTIVE;
        }
    }

    public void changeStatus(Status status) {
        this.status = status;
    }

}

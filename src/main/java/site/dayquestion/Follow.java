package site.dayquestion;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Follow extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "follow_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
    private Member follower;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
    private Member following;

}

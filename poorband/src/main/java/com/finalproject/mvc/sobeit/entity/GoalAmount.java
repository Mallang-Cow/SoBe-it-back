package com.finalproject.mvc.sobeit.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GoalAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goalAmountSeq;

    @Column(nullable = false)
    private Long goalAmount;

    @ManyToOne
    @JoinColumn(name = "userSeq", referencedColumnName = "userSeq")
    private Users userSeq;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false, length = 4)
    private String isSuccess;
}

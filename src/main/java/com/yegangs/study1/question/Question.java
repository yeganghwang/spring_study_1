package com.yegangs.study1.question;

import com.yegangs.study1.answer.Answer;
import com.yegangs.study1.user.SiteUser;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    @ManyToOne
    private SiteUser author;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}

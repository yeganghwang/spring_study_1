package com.yegangs.study1.question;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message="[필수] 제목을 입력하세요.")
    @Size(max=200)
    private String subject;

    @NotEmpty(message="[필수] 내용을 입력하세요.")
    private String content;
}

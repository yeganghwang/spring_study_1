package com.yegangs.study2;

import com.yegangs.study2.answer.Answer;
import com.yegangs.study2.answer.AnswerRepository;
import com.yegangs.study2.question.Question;
import com.yegangs.study2.question.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Study2ApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    @Transactional
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();
        answerList.forEach(answer -> {
           System.out.println(answer.getContent());
        });
        assertEquals("네, 자동으로 생성됩니다.", q.getAnswerList().getFirst().getContent());
    }
}

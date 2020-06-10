package com.survey.app.service;

import com.survey.app.model.Question;
import com.survey.app.repoository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question addQuestion(Question question) {
        log.info("save question db");
        return questionRepository.save(question);
    }
}

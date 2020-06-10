package com.survey.app.service;

import com.survey.app.model.Answer;
import com.survey.app.repoository.AnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public Answer addAnswer(Answer answer) {
        log.info("add answer in db");
        return answerRepository.save(answer);
    }

}

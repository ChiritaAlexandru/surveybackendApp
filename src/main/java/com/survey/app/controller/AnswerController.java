package com.survey.app.controller;

import com.survey.app.model.Answer;
import com.survey.app.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;


    @PostMapping(value = "/addAnswer")
    public Answer addAnswer(@RequestBody Answer answer){
        return answerService.addAnswer(answer);
    }

}

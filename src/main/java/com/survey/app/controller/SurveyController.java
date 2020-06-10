package com.survey.app.controller;

import com.survey.app.model.Survey;
import com.survey.app.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @RequestMapping("/defineSurvey")
    public Survey defineSurvey(@RequestBody Survey survey){
        return surveyService.defineSurvey(survey);
    }

    @GetMapping("/getSurveys")
    public List<Survey> getServeys(){
        return surveyService.getSurveys();
    }

}

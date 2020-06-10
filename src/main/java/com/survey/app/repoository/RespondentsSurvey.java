package com.survey.app.repoository;

import com.survey.app.model.Survey;
import com.survey.app.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respondents/survey")
public class RespondentsSurvey {

    @Autowired
    SurveyService surveyService;


    @PostMapping("/completeSurvey")
    public void completeSurvey(@RequestBody Survey survey){
        surveyService.defineSurvey(survey);
    }

    @RequestMapping("/mySurvey")
    public Survey getSurvey(@PathVariable int idUser){
       return  surveyService.getSurvey( idUser);
    }

}

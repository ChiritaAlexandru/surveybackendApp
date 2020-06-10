package com.survey.app.service;

import com.survey.app.model.Survey;
import com.survey.app.repoository.SurveyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;

    public Survey  defineSurvey(Survey survey){
        log.info("define Survey");
        return surveyRepository.save(survey);
    }

    public Survey getSurvey(int idUser) {
       return surveyRepository.findById(idUser).get();
    }

    public List<Survey> getSurveys() {
       return surveyRepository.findAll();
    }
}

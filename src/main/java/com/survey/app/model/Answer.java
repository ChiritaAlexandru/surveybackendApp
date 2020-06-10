package com.survey.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Answer implements  Comparable<Answer>{
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    private int idAnswer;
    private String answer;
    private boolean correctAnswer;
    private boolean chooseAnswer;

    @Override
    public int compareTo(Answer o) {
        return this.answer.compareTo(o.answer);
    }

}

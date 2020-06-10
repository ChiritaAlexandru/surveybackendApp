package com.survey.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Question {
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    private int idQuestion;
    private String textQuestion;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idQuestion")
    Set<Answer> answers;
    private boolean required;
}

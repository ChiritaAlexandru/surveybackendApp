package com.survey.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Survey {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSurvey;
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSurvey")
    private Set<Question> questions;
    private int idUser;
}

package com.eai.project.evaluation;

import com.eai.project.evaluator.Evaluator;
import com.eai.project.group.Group;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference(value = "evaluation-evaluator")
    @ManyToOne
    @JoinColumn(name = "evaluator_id")
    private Evaluator evaluator;

    @JsonBackReference(value = "evaluation-group")
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    private Date lastUpdated;

    private String criteria1;
    private String criteria2;

    //etc...
}

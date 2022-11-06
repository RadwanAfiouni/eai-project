package com.eai.project.evaluator;

import com.eai.project.evaluation.Evaluation;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evaluator")
public class Evaluator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference(value = "evaluation-evaluator")
    @OneToMany(mappedBy = "evaluator")
    private List<Evaluation> evaluations;

    private String firstName;
    private String lastName;
    private String email;

}

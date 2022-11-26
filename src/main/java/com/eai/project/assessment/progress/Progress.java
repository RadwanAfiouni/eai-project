package com.eai.project.assessment.progress;

import com.eai.project.Level;
import com.eai.project.evaluator.Evaluator;
import com.eai.project.group.Group;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "progress")
public class Progress {
    @Id
    @Column(name = "group_id")
    private Long id;
    private Date lastUpdated;

    @JsonManagedReference(value = "progress-group")
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "group_id")
    private Group group;

    @JsonManagedReference(value = "progress-evaluator")
    @ManyToOne
    @JoinColumn(name = "evaluator_id")
    private Evaluator evaluator;

    private Level criteria1;
    private Level criteria2;
    private Level criteria3;
    private Level criteria4;
    private Level criteria5;
    private Level criteria6;
    private Level criteria7;
    private Level criteria8;



}

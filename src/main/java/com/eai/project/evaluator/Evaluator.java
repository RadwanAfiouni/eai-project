package com.eai.project.evaluator;

import com.eai.project.assessment.advisorassessment.AdvisorAssessment;
import com.eai.project.assessment.finalreport.FinalReport;
import com.eai.project.assessment.oralproposal.OralProposal;
import com.eai.project.assessment.progress.Progress;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference(value = "advisor-assessment-evaluator")
    @OneToMany(mappedBy = "evaluator")
    private List<AdvisorAssessment> advisorAssessments;

    @JsonBackReference(value = "final-presentation-evaluator")
    @OneToMany(mappedBy = "evaluator")
    private List<AdvisorAssessment> finalPresentations;

    @JsonBackReference(value = "final-report-evaluator")
    @OneToMany(mappedBy = "evaluator")
    private List<FinalReport> finalReports;

    @JsonBackReference(value = "oral-proposal-evaluator")
    @OneToMany(mappedBy = "evaluator")
    private List<OralProposal> oralProposals;

    @JsonBackReference(value = "progress-evaluator")
    @OneToMany(mappedBy = "evaluator")
    private List<Progress> progresses;

    private String firstName;
    private String lastName;
    private String email;

}

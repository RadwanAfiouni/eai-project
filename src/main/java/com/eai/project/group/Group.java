package com.eai.project.group;

import com.eai.project.assessment.advisorassessment.AdvisorAssessment;
import com.eai.project.assessment.finalpresentation.FinalPresentation;
import com.eai.project.assessment.finalreport.FinalReport;
import com.eai.project.assessment.oralproposal.OralProposal;
import com.eai.project.assessment.progress.Progress;
import com.eai.project.student.Student;
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
@Table(name = "student_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "group")
    @JsonManagedReference(value = "student-group")
    private List<Student> students;

    @JsonBackReference(value = "advisor-assessment-group")
    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AdvisorAssessment advisorAssessment;

    @JsonBackReference(value = "final-report-group")
    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FinalPresentation finalPresentation;

    @JsonBackReference(value = "final-report-group")
    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FinalReport finalReport;

    @JsonBackReference(value = "oral-proposal-group")
    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private OralProposal oralProposal;

    @JsonBackReference(value = "progress-group")
    @OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Progress progress;

}


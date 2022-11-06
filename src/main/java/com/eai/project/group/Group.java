package com.eai.project.group;

import com.eai.project.evaluation.Evaluation;
import com.eai.project.student.Student;
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

    @JsonManagedReference(value = "evaluation-group")
    @OneToMany(mappedBy = "group")
    private List<Evaluation> evaluations;

}


package com.eai.project.student;

import com.eai.project.group.Group;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonBackReference(value = "student-group")
    private Group group;

    private String firstName;
    private String lastName;
    private String email;
}

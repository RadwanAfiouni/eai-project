package com.eai.project.student;

import com.eai.project.group.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.fetchAllStudents(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(studentService.fetchStudentById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Student> postStudent(@RequestBody StudentModel studentModel) {
        Student student = Student.builder()
                .group(studentModel.getGroupId() != null ? Group.builder().id(studentModel.getGroupId()).build() : null)
                .firstName(studentModel.getFirstName())
                .lastName(studentModel.getLastName())
                .email(studentModel.getEmail())
                .build();
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
    }

    @PutMapping(path = "/setGroup")
    public ResponseEntity<Group> setGroup(@RequestParam("studentId") String studentId, @RequestParam("groupId") String groupId) {
        return new ResponseEntity<>(studentService.setGroup(Long.valueOf(studentId), Long.valueOf(groupId)), HttpStatus.OK);
    }

}

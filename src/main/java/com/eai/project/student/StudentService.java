package com.eai.project.student;

import com.eai.project.group.Group;
import com.eai.project.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupService groupService;


    @Autowired
    public StudentService(StudentRepository studentRepository, GroupService groupService) {
        this.studentRepository = studentRepository;
        this.groupService = groupService;
    }

    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> fetchStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {

        if (student.getGroup() != null && !groupService.groupExists(student.getGroup().getId())) {
            groupService.saveGroup(student.getGroup());
        }
        return studentRepository.save(student);
    }

    public Group setGroup(Long studentId, Long groupId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Group> groupOptional = groupService.fetchGroupById(groupId);

        if (studentOptional.isEmpty()) {
            throw new IllegalArgumentException("Student with id " + studentId + " does not exist");
        }

        if (groupOptional.isEmpty()) {
            throw new IllegalArgumentException("Group with id " + groupId + " does not exist");
        }

        Student student = studentOptional.get();
        Group group = groupOptional.get();
        student.setGroup(group);
        studentRepository.save(student);
        return student.getGroup();

    }
}

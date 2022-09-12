package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(createdStudent);
    }
    @GetMapping("{studentId}")
    public ResponseEntity getStudent(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @PutMapping()
    public ResponseEntity updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("{studentId}")
    public void deleteUser(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
    @GetMapping()
    public ResponseEntity getStudentsOfAge(@RequestParam int age) {
        List<Student> studentList = studentService.studentsOfAge(age);
        if(studentList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }
}

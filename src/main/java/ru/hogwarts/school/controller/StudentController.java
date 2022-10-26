package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
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
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.update(student);
        return ResponseEntity.ok(createdStudent);
    }
    @GetMapping("{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
        Student student = studentService.getById(studentId);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.update(student);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }
    @GetMapping("/age{age}")
    public ResponseEntity<List<Student>> getStudentsOfAge(@PathVariable int age) {
        List<Student> studentList = studentService.getByAge(age);
        if(studentList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }
    @GetMapping("/age")
    public ResponseEntity<List<Student>> getStudentsOfAgeBetween(@RequestParam int min, @RequestParam int max) {
        List<Student> studentList = studentService.getByAgeBetween(min,max);
        if(studentList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAll();
        if(studentList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }
    @GetMapping("/D")
    public ResponseEntity<List<String>> getAllNameStartOnDStudents() {
        List<String> studentNamesList = studentService.getAllNameStartOnD();
        if(studentNamesList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentNamesList);
    }
    @GetMapping("{studentId}/faculty")
    public ResponseEntity<Faculty> getFacultyOfStudent(@PathVariable Long studentId) {
        Student student = studentService.getById(studentId);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        Faculty faculty = student.getFaculty();
        if(faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @GetMapping ("/count")
        public Long getCountAllStudents() {
        return studentService.getCountAllStudents();
        }
    @GetMapping ("/avgAge")
    public int avgAgeOfStudents() {
        return studentService.avgAgeOfStudents();
    }
    @GetMapping ("/last5students")
    public ResponseEntity<List<Student>> getLastStudents() {
        List<Student> studentList = studentService.getLast5Students();
        if(studentList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }
}

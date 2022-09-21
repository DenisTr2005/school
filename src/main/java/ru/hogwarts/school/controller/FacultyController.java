package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;


@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.update(faculty);
        return ResponseEntity.ok(createdFaculty);
    }
    @GetMapping("{facultyId}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.getById(facultyId);
        if(faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @PutMapping()
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.update(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }
    @DeleteMapping("{facultyId}")
    public void deleteFaculty(@PathVariable Long facultyId) {
        facultyService.delete(facultyId);
    }
    @GetMapping("/find")
    public ResponseEntity<List<Faculty>> getFacultiesByNameOrColor(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false) String color) {
        List<Faculty> facultyList = facultyService.getByNameOrColor(name,color);
        if(facultyList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyList);
    }
    @GetMapping()
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> facultyList = facultyService.getAll();
        if(facultyList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyList);
    }
    @GetMapping("{facultyId}/students")
    public ResponseEntity<Collection<Student>> getStudentsOfFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.getById(facultyId);
        if(faculty == null) {
            return ResponseEntity.notFound().build();
        }
        Collection<Student> students = faculty.getStudents();
        if(students == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(
                students.stream().
                sorted(Comparator.comparing(Student::getId)).
                toList());
    }
}

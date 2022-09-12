package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;
import java.util.List;


@RequestMapping("faculty")
@RestController
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(createdFaculty);
    }
    @GetMapping("{facultyId}")
    public ResponseEntity getFaculty(@PathVariable Long facultyId) {
        Faculty faculty = facultyService.getFacultyById(facultyId);
        if(faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }
    @DeleteMapping("{facultyId}")
    public void deleteUser(@PathVariable Long facultyId) {
        facultyService.deleteFaculty(facultyId);
    }
    @GetMapping()
    public ResponseEntity getFacultiesOfColor(@RequestParam String color) {
        List<Faculty> facultyList = facultyService.facultiesOfColor(color);
        if(facultyList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyList);
    }
}

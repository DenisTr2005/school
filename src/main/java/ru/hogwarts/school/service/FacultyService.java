package ru.hogwarts.school.service;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import java.util.List;
@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    public Faculty getFacultyById(Long facultyId) {
        return facultyRepository.findById(facultyId).orElse(null);
    }
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    public void deleteFaculty(Long facultyId) {
        facultyRepository.deleteById(facultyId);
    }
    public List<Faculty> facultiesOfColor(String color) {
        return facultyRepository.findAllByColor(color);
    }
}

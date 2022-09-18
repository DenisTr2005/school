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
    public Faculty getById(Long facultyId) {
        return facultyRepository.findById(facultyId).orElse(null);
    }
    public Faculty update(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    public void delete(Long facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    public List<Faculty> getByNameOrColor(String name, String color) {
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }
}

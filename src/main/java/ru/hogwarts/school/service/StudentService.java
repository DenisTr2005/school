package ru.hogwarts.school.service;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student getById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
    public Student update(Student student) {
        return studentRepository.save(student);
    }
    public void delete(Long studentId) {
        if (getById(studentId) != null) {
            studentRepository.deleteById(studentId);
        }
    }
    public List<Student> getByAge(int age) {
        return studentRepository.findAllByAge(age);
    }
    public List<Student> getByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
    public Long getCountAllStudents() {
        return studentRepository.countAllStudents();
    }
    public int avgAgeOfStudents() {
        return studentRepository.avgAgeOfStudents();
    }

    public List<Student> getLast5Students() {
        return studentRepository.getLast5Students();
    }
}

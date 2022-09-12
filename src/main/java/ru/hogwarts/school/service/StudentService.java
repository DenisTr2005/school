package ru.hogwarts.school.service;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import java.util.List;
@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    public List<Student> studentsOfAge(int age) {
        return studentRepository.findAllByAge(age);
    }

}

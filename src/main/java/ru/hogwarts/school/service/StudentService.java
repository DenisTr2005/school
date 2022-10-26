package ru.hogwarts.school.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student getById(Long studentId) {
        logger.info("Was invoked method for get student by id");
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            logger.warn("Getting student = null");
            logger.error("There is not student with id = {}",studentId);
        }
        logger.debug("Getting student = {}",student);
        return student;
    }
    public Student update(Student student) {
        logger.info("Was invoked method for update student");
        return studentRepository.save(student);
    }
    public void delete(Long studentId) {
        logger.info("Was invoked method for delete student by id");
        if (getById(studentId) != null) {
            studentRepository.deleteById(studentId);
        }
    }
    public List<Student> getByAge(int age) {
        logger.info("Was invoked method for get students by age");
        return studentRepository.findAllByAge(age);
    }
    public List<Student> getByAgeBetween(int min, int max) {
        logger.info("Was invoked method for get students by age between min and max");
        return studentRepository.findByAgeBetween(min, max);
    }
    public List<Student> getAll() {
        logger.info("Was invoked method for get all students");
        return studentRepository.findAll();
    }
    public List<String> getAllNameStartOnD() {
        logger.info("Was invoked method for get all students, the name of which starts on D");
        return studentRepository.findAll()
                .stream()
                .map(s->s.getName().toUpperCase())
                .filter(n->n.startsWith("D"))
                .sorted()
                .collect(Collectors.toList());
    }
    public Long getCountAllStudents() {
        logger.info("Was invoked method for get count of all students");
        return studentRepository.countAllStudents();
    }
    public int avgAgeOfStudents() {
        logger.info("Was invoked method for get average age of all students");
//        return studentRepository.avgAgeOfStudents();
        return (int) studentRepository.findAll()
                .stream()
                .mapToInt(s->s.getAge())
                .average().orElse(0);
    }

    public List<Student> getLast5Students() {
        logger.info("Was invoked method for get last five students");
        return studentRepository.getLast5Students();
    }
}

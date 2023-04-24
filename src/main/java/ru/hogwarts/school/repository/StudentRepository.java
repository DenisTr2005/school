package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByAge(int age);
    List<Student> findByAgeBetween(int min, int max);

    @Query(value = "SELECT count(*) FROM student", nativeQuery = true)
    Long countAllStudents();

    @Query(value = "SELECT avg(age) FROM student", nativeQuery = true)
    int avgAgeOfStudents();
    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> getLast5Students();

    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Student getLastStudent();
}

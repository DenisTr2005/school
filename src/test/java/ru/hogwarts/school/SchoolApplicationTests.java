package ru.hogwarts.school;



import static java.net.URI.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTests {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private StudentController studentController;
    final Student student = new Student();
    @BeforeEach
    private void settings() {
        student.setId(10L);
        student.setName("Denis");
        student.setAge(75);
    }

    @Test
    void createStudentTest() {
        String url = "http://localhost:" + port + "/student";
        assertThat(testRestTemplate.postForObject(url, student, Student.class))
                .isNotNull();
    }
    @Test
    void getStudentTest() {
        String url = "http://localhost:" + port + "/student/{studentId}";
        assertThat(testRestTemplate.getForObject(url,Student.class, student.getId()))
                .isEqualTo(student);
    }
    @Test
    void updateStudentTest() {
        student.setName("DenisUp");
        String url = "http://localhost:" + port + "/student";
        assertThat(testRestTemplate.postForObject(url, student, Student.class))
                .isNotNull();
    }
    @Test
    void deleteStudentTest() {
        String url = "http://localhost:" + port + "/student/{studentId}";
        testRestTemplate.delete(url, student.getId());
        assertThat(testRestTemplate.getForObject(url,Student.class,student.getId()))
                .isNull();
    }

}
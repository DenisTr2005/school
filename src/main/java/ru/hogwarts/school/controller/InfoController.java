package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.Student;

import java.util.stream.Stream;

@RestController
public class InfoController {
    @Value("${server.port}")
    private Integer port;
    @GetMapping("/getPort")
    public ResponseEntity<Integer> getPort() {
        return ResponseEntity.ok(port);
    }
    @GetMapping ("/getNumber")
    public long getNumber() {
//        long startTime = System.nanoTime();
        int sum = Stream.iterate(1, a -> a + 1)
                .limit(10_000_000)
                .parallel()
                .reduce(0, (a, b) -> a + b);

//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime)/1_000_000;
        return sum;
    }
}

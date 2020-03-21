package io.project.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardSpringApplication.class, args);
        System.out.println("io.Project is working");
    }

}

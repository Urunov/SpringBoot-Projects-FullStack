package io.project.bootbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootbaseApplication.class, args);

        System.out.println("Start to work");
    }

}

package spring.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DatabaseApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        // SpringApplication.run(DatabaseApplication.class, args);\
        new DatabaseApplication().configure(new SpringApplicationBuilder(DatabaseApplication.class)).run(args);
    }
    }



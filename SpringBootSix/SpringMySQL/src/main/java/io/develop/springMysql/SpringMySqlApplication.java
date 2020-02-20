package io.develop.springMysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("<package with entities>")
public class SpringMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMySqlApplication.class, args);
    }

}

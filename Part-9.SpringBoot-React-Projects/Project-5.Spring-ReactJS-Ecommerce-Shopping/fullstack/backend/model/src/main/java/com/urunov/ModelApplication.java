package com.urunov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

//@SpringBootApplication
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

//@EnableCaching
public class ModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelApplication.class, args);
    }

}

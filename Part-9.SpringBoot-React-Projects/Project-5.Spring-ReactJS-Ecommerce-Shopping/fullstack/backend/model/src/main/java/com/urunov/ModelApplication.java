package com.urunov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class ModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelApplication.class, args);
    }

}

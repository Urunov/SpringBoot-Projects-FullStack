package com.urunov;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.urunov.configure.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

@SpringBootApplication
@EnableSwagger2
//@ComponentScan(basePackages = {
//        "com.urunov.configure",
//        "com.urunov.controller",
//        "com.urunov.model",
//        "com.urunov.exception",
//        "com.urunov.repository",
//        "com.urunov.security",
//        "com.urunov.utils",
//        "com.urunov.kafkaService",
//        "com.urunov.service",
//        "com.urunov.schedule"
//})

public class ShoppingApplication {

    public static void main(String[] args) {
       // SpringApplication.run(new Class<?>[]{ShoppingApplication.class, JpaConfig.class}, args);

        SpringApplication.run(ShoppingApplication.class);
    }
//    @Bean
//    public JsonDeserializer jsonDeserializer()
//    {
//        return new JsonDeserializer()
//        {
//            @Override
//            public Object deserialize(JsonParser p, DeserializationContext context) throws IOException
//            {
//                return null;
//            }
//        };
//    }
//
//    @Bean
//    public ObjectMapper objectMapper()
//    {
//        return new ObjectMapper();
//    }
}

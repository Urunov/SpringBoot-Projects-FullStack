package com.project.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    //
    @Bean(name = "comp", initMethod = "turnOn", destroyMethod = "turnOf")
    Computer computer() {
        return new Computer();
    }
}

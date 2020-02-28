package com.project.spring.configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Computer {
    //

    @PostConstruct
    public void turnOn() {
        System.out.println("Load operating system");
    }

    @PreDestroy
    public void turnOf(){
        System.out.println("Close all programs");
    }
}

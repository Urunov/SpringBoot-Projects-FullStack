package com.project.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.stereotype.Component;

@Component
public class Alien {
    //
    private int id;
    private String name;
    private String tech;
    @Autowired
   // @Qualifier("lapp1") this may use component regarding laptop name... (ex>= Component("lap1")
    private Laptop laptop;

    public Alien() {
        super();
        System.out.println("Object created now.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void  show(){
        System.out.println("Spring boot object create as well. Now... ");
        laptop.compile();
    }
}

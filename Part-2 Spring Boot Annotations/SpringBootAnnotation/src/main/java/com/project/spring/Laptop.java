package com.project.spring;

import org.springframework.stereotype.Component;

//@Component("lap1")
@Component
public class Laptop {
    //
    private int lid;
    private String brand;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void compile() {
        System.out.println("compiling now laptop" );
    }
}

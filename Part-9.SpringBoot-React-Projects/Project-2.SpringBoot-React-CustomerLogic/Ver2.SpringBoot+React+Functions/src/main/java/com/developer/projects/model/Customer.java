package com.developer.projects.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Calendar;

/**
 * @Author: apple
 * @created on 13/07/2020
 * @Project is SpringBootReactCustomer
 */

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Name should be input")
    private String name;

    @NotNull(message = "Enter Date of Birth")
    private Calendar dob;

    @NotNull(message = "cridit value should be filled")
    private Double criditlimit;

    public Customer(int id) {
        this.id = id;
    }

    public Customer(String name, Calendar dob, Double creditlimit) {
        super();
        this.name = name;
        this.dob = dob;
        this.criditlimit = creditlimit;
    }

    public Customer(){

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

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public Double getCriditlimit() {
        return criditlimit;
    }

    public void setCriditlimit(Double criditlimit) {
        this.criditlimit = criditlimit;
    }
}

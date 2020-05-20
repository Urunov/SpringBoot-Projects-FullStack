package spring.project.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

/**
 * @Author: apple
 * @created on 02/05/2020
 * @Project is EmployeeSalary
 */

@Entity
@Table(name = "employeeinfo")
public class Employee {


    private Long id;

    private String name;
    private float salary;
    private String designation;

    public Employee(){}

    public Employee(Long id, String name, Float salary, String designation) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation =designation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

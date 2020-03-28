package spring.aop.model;

import org.aspectj.lang.annotation.AfterReturning;

import javax.persistence.*;

/**
 * @Created 25 / 03 / 2020 - 9:25 AM
 * @project SpringAspectOrinentProgram
 * @Author Hamdamboy
 */

@Entity
@Table(name="employees")
public class Employee {
    //
    private long id;
    private String firstName;
    private String lastName;


    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String emailId;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String emailId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }

    @Column(name="first_name", nullable = false)
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Column(name="email_address", nullable = false)
    public String getEmailId(){
        return emailId;
    }

    public void setEmailId(String emailId){
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}

package spring.restdb.model;

import javax.persistence.*;

/**
 * @Created 01 / 04 / 2020 - 5:16 PM
 * @project SpringRestDB
 * @Author Hamdamboy
 */

@Entity
@Table(name = "jobs")
public class Employee {
    //
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "emailId", nullable = false)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Employee(){}

    public Employee(String firstName, String lastName, String emailId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }


}

package spring.database.model;


import javax.persistence.*;

/**
 * @Author: apple
 * @created on 28/03/2020
 * @Project is SpringPosgreslq
 */


@Entity
@Table(name="postgresql")
public class Employee {
    //


    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   // @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return emailId;
    }

    public void setEmail(String email) {
        this.emailId = email;
    }

    public Employee(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + emailId + '\'' +
                '}';
    }

}

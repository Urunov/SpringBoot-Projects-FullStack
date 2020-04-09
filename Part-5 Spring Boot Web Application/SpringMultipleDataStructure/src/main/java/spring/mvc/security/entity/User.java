package spring.mvc.security.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @Created 08 / 04 / 2020 - 5:38 PM
 * @project SpringMultipleDataStructure
 * @Author Hamdamboy
 */

@Entity
@Table(name = "USERS")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;
    private boolean disabled;

    @OneToMany(mappedBy = "user")
    private Set<Address> address;

    public User(){}
    public User(Integer id, String name, String email, boolean disabled) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.disabled = disabled;
    }
    public User(Integer id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
}

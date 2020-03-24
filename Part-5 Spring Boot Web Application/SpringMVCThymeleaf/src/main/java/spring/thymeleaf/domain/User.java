package spring.thymeleaf.domain;

import javax.persistence.*;

/**
 * @Created 24 / 03 / 2020 - 3:19 PM
 * @project SpringMVCDatabase
 * @Author Hamdamboy
 */

@Entity
@Table(name = "company")
public class User {
    //

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

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

    public User(){

    }

    public User(Integer id, String name){
        this.id = id;
        this.name = name;
    }


}

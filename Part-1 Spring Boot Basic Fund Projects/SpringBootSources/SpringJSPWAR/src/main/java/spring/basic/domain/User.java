package spring.basic.domain;

import javax.persistence.*;

/**
 * @Created 24 / 03 / 2020 - 10:15 AM
 * @project SpringJSPWAR
 * @Author Hamdamboy
 */

@Entity
@Table(name="thewatch")
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

    public User() {

    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


}

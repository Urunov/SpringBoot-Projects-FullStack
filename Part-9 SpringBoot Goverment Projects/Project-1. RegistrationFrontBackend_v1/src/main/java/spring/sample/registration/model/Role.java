package spring.sample.registration.model;

import javax.persistence.*;

/**
 * @Created 29 / 06 / 2020 - 6:37 PM
 * @project RegistrationPerson
 * @Author Hamdamboy
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    public Role(String name) {

        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

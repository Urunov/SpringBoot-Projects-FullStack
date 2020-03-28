package spring.mvc.domain;

import javax.persistence.*;

/**
 * @Created 27 / 03 / 2020 - 12:19 PM
 * @project SpringMVC
 * @Author Hamdamboy
 */

@Entity
@Table(name = "company")
public class Company {

    private Integer id;
    private String name;

    public Company(){}

    public Company(Integer id, String name){
        this.id = id;
        this.name =name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id =id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}

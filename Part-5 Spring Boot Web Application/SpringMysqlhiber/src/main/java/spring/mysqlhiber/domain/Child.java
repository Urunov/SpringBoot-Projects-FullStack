package spring.mysqlhiber.domain;


import javax.persistence.*;

/**
 * @Created 07 / 04 / 2020 - 5:52 PM
 * @project SpringMysqlhiber
 * @Author Hamdamboy
 */
@Entity
@Table(name = "child")
public class Child {

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

    public Child(){}

    public Child(Integer id, String name){
        this.id = id;
        this.name = name;
    }


}

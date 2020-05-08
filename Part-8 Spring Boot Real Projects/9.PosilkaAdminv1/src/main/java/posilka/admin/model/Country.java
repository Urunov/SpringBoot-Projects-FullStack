package posilka.admin.model;

import javax.persistence.*;

/**
 * @Created 07 / 05 / 2020 - 1:40 PM
 * @project AdminPage
 * @Author Hamdamboy
 */
@Entity
//@Table(name = "country")
public class Country {

    private Long id;
    private String name;
    private String picture;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }



    public Country(Long id, String name, String picture){
        super();
        this.id = id;
        this.name =name;
        this.picture = picture;
    }

    public Country(){}
}

package spring.annotation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Created 30 / 03 / 2020 - 3:20 PM
 * @project Springannotation
 * @Author Hamdamboy
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Developer {
    //
    private int id;
    private String name;
    private String blog;
    private int phone;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blog='" + blog + '\'' +
                ", phone=" + phone +
                '}';
    }
}

package spring.annotation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Created 31 / 03 / 2020 - 9:54 AM
 * @project Springannotation
 * @Author Hamdamboy
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    //
    private String name;
    private String blog;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBlog(){
        return blog;
    }

    public void setBlog(String blog){
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", blog='" + blog + '\'' +
                '}';
    }
}

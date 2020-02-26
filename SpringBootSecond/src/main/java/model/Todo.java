package model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table

public class Todo {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    @Size(min = 10, message = "Enter at least 10 Characters.")
    private String description;

    private Date targetDate;
    public Todo() {
        super();
    }

    public Todo(String name, String description, Date targetDate, boolean isDone) {
        //
        super();
        this.userName = name;
        this.description = description;
        this.targetDate = targetDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

// https://www.javaguides.net/2018/09/mini-todo-management-project-using-spring-boot-springmvc-springsecurity-jsp-hibernate-mysql.html
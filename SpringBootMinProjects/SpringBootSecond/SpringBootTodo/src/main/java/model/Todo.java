package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_todos")

public class Todo implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    private boolean finished;

    public Todo(String name, String description, Date dateCreate, boolean finished) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreate = dateCreate;
        this.finished = finished;
    }

    public Todo() {
        super();
    }
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreate=" + dateCreate +
                ", finished=" + finished +
                '}';
    }
}

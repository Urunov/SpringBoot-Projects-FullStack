package spring.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: apple
 * @created on 30/04/2020
 * @Project is SpringSimpleTodo
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String todoItem;
    private String completed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(String todoItem) {
        this.todoItem = todoItem;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public ToDo(String todoItem, String completed){
        super();
        this.todoItem = todoItem;
        this.completed = completed;
    }
}

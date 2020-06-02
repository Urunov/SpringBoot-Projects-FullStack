package spring.project.entity;

import javax.persistence.*;


/**
 * @Author: apple
 * @created on 30/04/2020
 * @Project is SpringSimpleTodo
 */
@Entity
@Table(name = "schedule")
class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String todoItem;
    private String completed;

  public ToDo(){}
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

    public ToDo(long id) {
        this.id = id;
    }
}

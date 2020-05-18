package spring.hibernate.service;

import spring.hibernate.model.Todo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Created 18 / 05 / 2020 - 3:39 PM
 * @project ProjectTodo
 * @Author Hamdamboy
 */

public interface ITodoService {

    List<Todo> getTodoByUser(String user);

    Optional<Todo> getTodoById(long id);

    void updateTodo(Todo todo);

    void addTodo(String name, String desc, Date targetDate, boolean isDone);

    void deleteTodo(long id);

    void saveTodo(Todo todo);

    Object getTodosByUser(String name);
}

package spring.project.service;

import spring.project.model.Todo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Created 28 / 04 / 2020 - 3:25 PM
 * @project SpringToDoSimple
 * @Author Hamdamboy
 */

public interface ITodoService {

    List<Todo> getTodosByUser(String user);

    Optional<Todo> getTodoById(long id);

    void updateTodo(Todo todo);

    void addTodo(String name, String desc, Date targetDate, boolean isDone) ;

    void deleteTodo(long id);

    void saveTodo(Todo todo);

    }


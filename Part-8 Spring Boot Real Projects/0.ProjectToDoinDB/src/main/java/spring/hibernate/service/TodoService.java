package spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import spring.hibernate.model.Todo;
import spring.hibernate.repository.TodoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Created 18 / 05 / 2020 - 3:50 PM
 * @project ProjectTodo
 * @Author Hamdamboy
 */

@Service
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getTodoByUser(String user) {
        return todoRepository.findByUserName(user);
    }

    @Override
    public Optional<Todo> getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        todoRepository.save(new Todo(name, desc, targetDate, isDone));
    }

    @Override
    public void deleteTodo(long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent()) {
            todoRepository.delete(todo.get());
        }
    }

    @Override
    public void saveTodo(Todo todo) {
            todoRepository.save(todo);
    }

    @Override
    public Object getTodosByUser(String name) {
        return null;
    }
}

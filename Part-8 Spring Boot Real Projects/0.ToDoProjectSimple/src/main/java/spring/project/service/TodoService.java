package spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import spring.project.model.Todo;
import spring.project.repository.TodoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Created 28 / 04 / 2020 - 3:27 PM
 * @project SpringToDoSimple
 * @Author Hamdamboy
 */
@Service
public class TodoService implements ITodoService{

    @Autowired
    private TodoRepository todoRepository;


    @Override
    public List<Todo> getTodosByUser(String user) {
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
}

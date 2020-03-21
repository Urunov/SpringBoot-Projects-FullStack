package controller;

import model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.TodosService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class TodosController {
    //
    @Autowired
    private TodosService todosService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/all-todos")
    public String allTodos(HttpServletRequest request) {
        request.setAttribute("todos", todosService.findAll());
        request.setAttribute("mode", "MODE_TODOS");
        return "index";
    }

    @GetMapping("/new-todo")
    public String newTodo(HttpServletRequest request) {
        //
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @PostMapping("/save-todo")
    public String saveTodo(@ModelAttribute Todo todo, BindingResult bindingResult, HttpServletRequest request) {
        todo.setDateCreated(new Date());
        todosService.save(todo);
        request.setAttribute("todos", todosService.findAll());
        request.setAttribute("mode", "MODE_TODOS");
        return "index";
    }

    @GetMapping("/update-todo")
    public String updateTodo(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("todo", todosService.findTodo(id).get());
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }
    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id, HttpServletRequest request) {
        todosService.delete(id);
        request.setAttribute("todos", todosService.findAll());
        request.setAttribute("mode", "MODE_TODOS");
        return "index";
    }
}

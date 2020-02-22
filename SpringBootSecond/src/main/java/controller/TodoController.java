package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ITodoService;

@Controller
public class TodoController {
    //

    @Autowired
    private ITodoService todoService;


}

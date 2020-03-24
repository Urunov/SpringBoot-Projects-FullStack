package controllers;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MainService;

import java.util.Collection;

@RestController

@CrossOrigin
public class MainRestController {
        //
    @RequestMapping("/")
    public String show(){
        return "index";
    }

    @Autowired
    private MainService mainService;

    @GetMapping(value = "/")
    public String hello(){
        return "Hello Again.";
    }

    @GetMapping("/findAllBook")
    public Collection<Book> getAllBooks(){

        return mainService.findAllBooks();
    }
}

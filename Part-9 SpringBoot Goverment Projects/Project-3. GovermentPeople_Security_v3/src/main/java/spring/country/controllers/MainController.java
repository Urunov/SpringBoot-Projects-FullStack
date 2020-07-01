package spring.sample.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Created 30 / 06 / 2020 - 3:09 PM
 * @project RegistrationPerson
 * @Author Hamdamboy
 */
@Controller
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String indexValue(){
        return "index";
    }
}

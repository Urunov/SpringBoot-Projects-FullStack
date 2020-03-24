package spring.basic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.basic.repositories.UserRepository;

/**
 * @Created 24 / 03 / 2020 - 10:15 AM
 * @project SpringJSPWAR
 * @Author Hamdamboy
 */

@Controller
public class UserController {
    //

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String show(){
        return "Spring Boot is working well";
    }

    //@RequestMapping("/users")
    @GetMapping("/user")
    public String home(Model model) {
        model.addAttribute("thewatch", userRepository.findAll());
        return "users";
    }


}

package spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created 10 / 04 / 2020 - 11:38 AM
 * @project SpringSecuritySimpleExample
 * @Author Hamdamboy
 */

@RestController
public class DefaultController {

    @GetMapping(value = "/")
    public String home1(){
        return "home.html";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/403")
    public String error403(){
        return "/error/403";
    }
}

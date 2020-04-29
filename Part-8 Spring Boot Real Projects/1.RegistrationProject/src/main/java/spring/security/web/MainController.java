package spring.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Created 29 / 04 / 2020 - 5:31 PM
 * @project SpringRegistor
 * @Author Hamdamboy
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/user")
    public String userIndex(){
        return "user/index";
    }
}

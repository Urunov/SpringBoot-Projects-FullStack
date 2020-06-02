package aspera.registration.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Created 02 / 06 / 2020 - 2:39 PM
 * @project SpringRegistration
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

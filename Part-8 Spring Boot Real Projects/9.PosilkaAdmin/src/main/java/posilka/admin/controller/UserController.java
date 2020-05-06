package posilka.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Created 06 / 05 / 2020 - 2:13 PM
 * @project AdminPage
 * @Author Hamdamboy
 */
@Controller
public class UserController {

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }
}

package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: apple
 * @created on 15/04/2020
 * @Project is SpringSecRoleBased
 */
@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("index")
    public String index(){
        return "index";
    }
}

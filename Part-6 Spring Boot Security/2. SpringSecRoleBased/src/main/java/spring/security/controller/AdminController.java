package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: apple
 * @created on 15/04/2020
 * @Project is SpringSecRoleBased
 */

@Controller
@RequestMapping("admin")
public class AdminController {
    //
    @GetMapping("index")
    public String admin(){
        return "admin/index";
    }
}

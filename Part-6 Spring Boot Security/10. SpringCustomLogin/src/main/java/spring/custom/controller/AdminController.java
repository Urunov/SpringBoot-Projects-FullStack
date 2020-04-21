package spring.custom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: apple
 * @created on 20/04/2020
 * @Project is SpringCustomLogin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String index(){
        return "admin/index";
    }
}

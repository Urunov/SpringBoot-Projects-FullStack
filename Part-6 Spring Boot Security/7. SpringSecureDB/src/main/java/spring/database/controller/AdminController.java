package spring.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created 16 / 04 / 2020 - 11:51 AM
 * @project security
 * @Author Hamdamboy
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}

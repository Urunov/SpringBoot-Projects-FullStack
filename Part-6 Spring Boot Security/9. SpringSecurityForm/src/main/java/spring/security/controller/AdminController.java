package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created 13 / 04 / 2020 - 10:21 AM
 * @project SpringSecurityForm
 * @Author Hamdamboy
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping()
    public String index(){
        return "admin/index";
    }
}

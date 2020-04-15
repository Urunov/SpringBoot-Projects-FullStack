package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created 14 / 04 / 2020 - 3:27 PM
 * @project SpringUnSecurityPlus
 * @Author Hamdamboy
 */

@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping("index")
    public String admin(){
        return "admin/index";
    }
}

package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created 14 / 04 / 2020 - 3:27 PM
 * @project SpringSecurityHTTP
 * @Author Hamdamboy
 */

@Controller
@RequestMapping("")
public class HomeController {
    @GetMapping("index")
    public String index(){
        return "index";
    }
}

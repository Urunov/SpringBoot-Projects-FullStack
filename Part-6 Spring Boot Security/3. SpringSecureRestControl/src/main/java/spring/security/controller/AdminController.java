package spring.security.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created 16 / 04 / 2020 - 10:34 AM
 * @project SpringSecureRestControl
 * @Author Hamdamboy
 */

@Configuration
@RequestMapping("admin/index")
public class AdminController {

    @GetMapping("index")
    public String admin(){
        return "index";
    }
}

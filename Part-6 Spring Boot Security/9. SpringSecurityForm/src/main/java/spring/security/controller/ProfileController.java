package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created 13 / 04 / 2020 - 10:21 AM
 * @project SpringSecurityForm
 * @Author Hamdamboy
 */

@Controller
@RequestMapping("/profile")
public class ProfileController {
    //
    @GetMapping("/index")
    public String index(){
        return "profile/index";
    }
}

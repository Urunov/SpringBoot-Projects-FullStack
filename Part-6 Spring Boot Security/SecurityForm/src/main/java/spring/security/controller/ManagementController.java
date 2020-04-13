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
@RequestMapping("management")
public class ManagementController {

    @GetMapping
    public String index(){
        return "management/index";
    }
}

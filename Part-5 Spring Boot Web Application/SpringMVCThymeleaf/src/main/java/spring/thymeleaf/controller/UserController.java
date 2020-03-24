package spring.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.thymeleaf.repositories.UserRopository;

/**
 * @Created 24 / 03 / 2020 - 3:20 PM
 * @project SpringMVCDatabase
 * @Author Hamdamboy
 */

@Controller
public class UserController {
    //
    @Autowired
    UserRopository userRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("company", userRepository.findAll());
        return "index";
    }
}

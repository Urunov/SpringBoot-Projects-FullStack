package spting.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spting.validation.model.User;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @Created 09 / 06 / 2020 - 3:55 PM
 * @project SpringValidationThymeleaf
 * @Author Hamdamboy
 */
@Controller
public class MainController {

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model) {
        System.out.println(user);

        if (bindingResult.hasErrors()) {
            List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
            model.addAttribute("listProfession", listProfession);

            return "register_form";
        } else {
            return "register_success";
        }
    }

}



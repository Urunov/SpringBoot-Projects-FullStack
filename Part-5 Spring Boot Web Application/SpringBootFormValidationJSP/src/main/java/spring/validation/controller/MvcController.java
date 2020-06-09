package spring.validation.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.validation.model.User;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
/**
 * @Created 09 / 06 / 2020 - 1:41 PM
 * @project SpringBootValidationJSP
 * @Author Hamdamboy
 */
@Controller
public class MvcController {

    @RequestMapping("/")
    public String home() {
        System.out.println("Going home...");
        return "index";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        user.setName("Urunov");
        model.addAttribute("user", user);

        List<String> professionList = Arrays.asList("Developer", "Designer", "Art", "Architect", "Teacher", "Trainer");
        model.addAttribute("professionList", professionList);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model) {
        System.out.println("Professing form...");
        System.out.println(user);

        if (bindingResult.hasErrors()) {
            List<String> professionList = Arrays.asList("Developer", "Designer", "Tester", "Architect");
            model.addAttribute("professionList", professionList);
            return "register_form";
        }

        return "register_success";
    }
}

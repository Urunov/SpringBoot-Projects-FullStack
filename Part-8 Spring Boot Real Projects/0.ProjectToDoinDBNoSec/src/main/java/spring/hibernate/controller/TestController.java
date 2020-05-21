package spring.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Created 20 / 05 / 2020 - 3:53 PM
 * @project ProjectTodo
 * @Author Hamdamboy
 */
//
//@Controller
//public class TestController {
//
//    private static final String message = "Hello World Hamdamboy";
//
//    @GetMapping(value = "/")
//    public String welcome(Map<String, Object> model) {
//        model.put("message" , this.message);
//        return "index";
//    }
//}

@Controller
public class TestController {

    private String message = "Hello World";
    @RequestMapping("/list")
    public String test(Model model) {

        model.addAttribute("message", message);

        return "welcome";
    }
}

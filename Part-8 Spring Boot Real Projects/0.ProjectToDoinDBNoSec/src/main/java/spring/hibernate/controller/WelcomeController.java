package spring.hibernate.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Created 18 / 05 / 2020 - 2:00 PM
 * @project ProjectTodo
 * @Author Hamdamboy
 */
@RestController
public class WelcomeController {

    @GetMapping("/start")
    public String index() {
        return "index";
    }


    private String message = "Hello World";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showWelcomePage(Map<String, Object> modelMap) {
     modelMap.put("message", this.message);

     ModelAndView mav = new ModelAndView("index");
        return mav;
    }


}

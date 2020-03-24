package spring.basic;



/**
 @Author: ${USER}
 @created on ${DATE}
 @Project is ${PROJECT_NAME}
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerMember{

   //private final AtomicLong counter = new AtomicLong();

    @GetMapping()
    public String test() {
        return "member  is working";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/adding")
    public String addMember(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "member";
    }



}

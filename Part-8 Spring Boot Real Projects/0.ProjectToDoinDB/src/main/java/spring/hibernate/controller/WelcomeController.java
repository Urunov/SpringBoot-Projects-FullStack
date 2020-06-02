package spring.hibernate.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Created 18 / 05 / 2020 - 2:00 PM
 * @project ProjectTodo
 * @Author Hamdamboy
 */
@Controller
public class WelcomeController {

//    @GetMapping("/start")
//    public String index() {
//        return "login";
//    }
//
//    @GetMapping("/login")
//    public String loginAgain(){
//        return "index";
//    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap modelMap) {
        modelMap.put("name", getLoggedinUserName());
        return "welcome";
    }

    private String getLoggedinUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }
}

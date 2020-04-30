package spring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created 28 / 04 / 2020 - 3:17 PM
 * @project SpringToDoSimple
 * @Author Hamdamboy
 */
@Controller
public class WelcomeController {

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping(value = "/")
    public String showWelcomePage(){
        return "welcome";
    }
//    public String showWelcomePage(ModelMap modelMap) {
//        modelMap.put("name", getLoggedinUserName());
//        return "welcome";
//    }

//    private String getLoggedinUserName() {
//        Object principal = SecurityContextHolder.getContext()
//                .getAuthentication().getPrincipal();
//
//        if(principal instanceof UserDetails) {
//            return ((UserDetails) principal).getUsername();
//        }
//
//        return principal.toString();
//    }

}

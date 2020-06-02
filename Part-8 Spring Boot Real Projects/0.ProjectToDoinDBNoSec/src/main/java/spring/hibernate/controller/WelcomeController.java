package spring.hibernate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Created 18 / 05 / 2020 - 2:00 PM
 * @project ProjectTodo
 * @Author Hamdamboy
 */
    @Controller
    public class WelcomeController {

        private String message = "Hello World";

      //  @RequestMapping(value = "", method = RequestMethod.GET)
//        @GetMapping("")
//        public ModelAndView showWelcomePage(Map<String, Object> modelMap) {
//            modelMap.put("message", this.message);
//
//            ModelAndView mav = new ModelAndView("welcome");
//            return mav;
//        }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showWelcomePage(Map<String, Object> modelMap) {
            modelMap.put("message", this.message);

            ModelAndView mav = new ModelAndView("welcome");
            return mav;
        }
    }
/***
 *  This project :
 *   When you integrate (template) folder information is working well (as html, htm..)
 *   But webapp/WEB-INF/jsp --> mapping not working , other logic is working.
 *
 * */
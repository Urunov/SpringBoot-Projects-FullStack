package spring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Created 28 / 04 / 2020 - 3:19 PM
 * @project SpringToDoSimple
 * @Author Hamdamboy
 */
@Controller("/error")
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("exception", ex.getLocalizedMessage());
        mv.addObject("url", request.getRequestURI());

        mv.setViewName("error");
        return mv;
    }
}

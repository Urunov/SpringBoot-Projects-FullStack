package spring.project.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Created 28 / 04 / 2020 - 3:21 PM
 * @project SpringToDoSimple
 * @Author Hamdamboy
 */
@RestController
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication authencation = SecurityContextHolder.getContext()
                .getAuthentication();

        if(authencation !=null) {
            new SecurityContextLogoutHandler().logout(request, response, authencation);
        }

        return "redirect:/";
    }
}

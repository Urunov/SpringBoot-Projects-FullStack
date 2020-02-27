package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/*
 *   @Valid  - data validation,
 *   @ ModelAttribute - The input of the submitted form will be explicitly, mapped to the method
 *                       parameter form via the annotation.
 * */
@Controller
@RequestMapping("/")

public class LoginHandler {
    //
    private static final String LOGIN_VIEW = "login";
    private static final String LOGOUT_VIEW = "logout";

    @GetMapping("/get")
    public String showLoginView(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return LOGIN_VIEW;
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm form,
                        BindingResult bindingResult,
                        HttpSession session) {
            if(!bindingResult.hasErrors()) {
                final boolean authenticated = "myindexu@gmail.com".equals(form.getEmail());
                final String loginStatus = authenticated ? "OK" : " FAILED";

                session.setAttribute("loginStatus", loginStatus);
        }

            return LOGIN_VIEW;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginStatus");
        return LOGOUT_VIEW;
    }
}

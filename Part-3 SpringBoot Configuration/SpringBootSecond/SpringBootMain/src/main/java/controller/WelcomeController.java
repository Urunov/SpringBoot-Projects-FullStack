package controller;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WelcomeController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("WelcomePage");
        return model;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showWelcomePage(ModelMap model1){
        //model.put("name", getLoggedinUserName());
        ModelAndView model = new ModelAndView();
        model.setViewName("index");;
        //return "index";
        return model;
    }

    private String getLoggedinUserName() {
        //
        /*Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if(principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }*/
        //return principal.toString();
        return "index";
    }
}

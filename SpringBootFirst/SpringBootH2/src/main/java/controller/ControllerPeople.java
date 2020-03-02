package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.Reposotory;

@Controller
public class ControllerPeople {

    @Autowired
    Reposotory repo;

    @RequestMapping("/")
    public String home()
    {
        return "index.jsp";
    }

}

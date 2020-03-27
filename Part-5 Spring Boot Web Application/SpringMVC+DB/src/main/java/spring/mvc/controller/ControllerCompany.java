package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvc.repository.CompanyRepository;

/**
 * @Created 27 / 03 / 2020 - 12:19 PM
 * @project SpringMVC
 * @Author Hamdamboy
 */
@Controller
public class ControllerCompany {
    //
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/get")
    public String again(){
       // model.addAttribute("company", companyRepository.findAll());
        return "working";
    }
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("company", companyRepository.findAll());
        return "index";
    }
}

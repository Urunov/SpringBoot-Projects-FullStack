package spring.mvc.controller;

import com.fasterxml.jackson.databind.util.ViewMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.mvc.repository.CompanyRepository;

/**
 * @Created 27 / 03 / 2020 - 12:19 PM
 * @project SpringMVC
 * @Author Hamdamboy
 */
@RestController
public class ControllerCompany {
    //
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/get")
    public String again(){
       // model.addAttribute("company", companyRepository.findAll());
        return "working";
    }

    @RequestMapping(value = "/to", method = RequestMethod.GET)
    public String home(@PathVariable int id, Model model){
        model.addAttribute("index",  companyRepository.findById(id));
        return "redirect:/index";

    }
}

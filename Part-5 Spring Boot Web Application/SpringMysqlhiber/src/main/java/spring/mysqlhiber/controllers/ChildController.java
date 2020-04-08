package spring.mysqlhiber.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mysqlhiber.repository.ChildRepository;

/**
 * @Created 07 / 04 / 2020 - 5:51 PM
 * @project SpringMysqlhiber
 * @Author Hamdamboy
 */

@Controller
public class ChildController {
    //
    @Autowired
    ChildRepository childRepository;

    @RequestMapping("/child")
    public String childeren(Model model){
        model.addAttribute("child", childRepository.findAll());
        return "index";
    }
}

package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.mvc.service.entity.UserOrdersService;

/**
 * @Created 08 / 04 / 2020 - 5:44 PM
 * @project SpringMultipleDataStructure
 * @Author Hamdamboy
 */
@Controller
public class HomeController {
    //
    @Autowired
    private UserOrdersService userOrdersService;

    @RequestMapping(value = {"/", "/app/users"}, method = RequestMethod.GET)
    public String getUsers(Model model){
        model.addAttribute("users", userOrdersService.getUsers());
        model.addAttribute("orders", userOrdersService.getOrders());

        return "users";
    }
}

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Created 22 / 05 / 2020 - 1:28 PM
 * @project SpringJSP
 * @Author Hamdamboy
 */
@Controller
public class Controllers {

    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "How to do Spring in JSP ");
        return "index";
    }

    @RequestMapping("/next")
    public String next(Map<String, Object> model) {
        model.put("message", "You are in new page");
        return "next";
    }
}

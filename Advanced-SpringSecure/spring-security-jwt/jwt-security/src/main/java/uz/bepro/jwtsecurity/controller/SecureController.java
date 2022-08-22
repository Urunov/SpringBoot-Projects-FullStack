package uz.bepro.jwtsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: jwt-security
 * @Date: 19.08.2022
 * @author: H_Urunov
 **/
@RestController
public class SecureController {
    //
    @RequestMapping("/hello")
    public String firstPage() {

     return "Hello";
    }
}

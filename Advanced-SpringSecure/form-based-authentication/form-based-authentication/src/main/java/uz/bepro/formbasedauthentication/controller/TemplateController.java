package uz.bepro.formbasedauthentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: form-based-authentication
 * @Date: 17.08.2022
 * @author: H_Urunov
 **/
@RestController
@RequestMapping("/")
public class TemplateController {
    //
    private static final String PATH = "login";

    @GetMapping(value = PATH)
    public String getLoginView(){
        return "login";
    }
}

package com.okta.developer.jugtour.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: apple
 * @created on 13/07/2020
 * @Project is SpringReactCrud
 */

@Controller
@Profile("prod")
public class RedirectController {

    @GetMapping("/private")
    public String redirectToRoot() {
        return "redirect:/";
    }
}

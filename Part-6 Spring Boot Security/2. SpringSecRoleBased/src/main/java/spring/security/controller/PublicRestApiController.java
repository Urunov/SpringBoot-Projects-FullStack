package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: apple
 * @created on 15/04/2020
 * @Project is SpringSecRoleBased
 */

@Controller
@RequestMapping("api/public")
public class PublicRestApiController {

    @GetMapping("test1")
    public String index(){
        return "testing 1";
    }

    @GetMapping("test2")
    public String index2(){
        return "API Test 2";
    }
}

package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created 16 / 04 / 2020 - 11:53 AM
 * @project security
 * @Author Hamdamboy
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

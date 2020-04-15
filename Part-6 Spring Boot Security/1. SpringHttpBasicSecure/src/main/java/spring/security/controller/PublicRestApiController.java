package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created 14 / 04 / 2020 - 3:27 PM
 * @project SpringSecurityHTTP
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

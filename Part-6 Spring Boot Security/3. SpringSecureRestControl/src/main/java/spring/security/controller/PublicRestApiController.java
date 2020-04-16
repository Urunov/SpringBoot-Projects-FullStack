package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created 16 / 04 / 2020 - 10:34 AM
 * @project SpringSecureRestControl
 * @Author Hamdamboy
 */
@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
    //

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }

}

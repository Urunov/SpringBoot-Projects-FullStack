package spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.security.dao.UserRepository;
import spring.security.model.User;

import java.util.List;

/**
 * @Created 13 / 04 / 2020 - 10:21 AM
 * @project SpringSecurityForm
 * @Author Hamdamboy
 */
@RestController
@RequestMapping("/api/public")
public class PublicRestApiController {

    private UserRepository userRepository;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "API TEST 2";
    }

    @GetMapping("/users")
    public List<User> users(){

        return this.userRepository.findAll();
    }
}

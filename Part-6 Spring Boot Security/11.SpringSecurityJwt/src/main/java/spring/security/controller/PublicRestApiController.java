package spring.security.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.security.db.UserRepository;
import spring.security.model.User;

import java.util.List;

/**
 * @Created 24 / 04 / 2020 - 1:51 PM
 * @project SpringSecurityJWT
 * @Author Hamdamboy
 */

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {
    private UserRepository userRepository;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Avialable to all authentication users
    @GetMapping("test")
    public String test1(){
        return "API Test";
    }

    // Available to managers
    @GetMapping("management/reports")
    public String reports(){
        return "Some report data";
    }

    // Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public List<User> users(){
        return this.userRepository.findAll();
    }
}

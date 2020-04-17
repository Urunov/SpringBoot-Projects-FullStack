package spring.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.database.db.UserRepository;
import spring.database.model.User;

import java.util.List;

/**
 * @Created 16 / 04 / 2020 - 11:53 AM
 * @project security
 * @Author Hamdamboy
 */
@Controller
@RequestMapping("api/public")
public class PublicRestApiController {

    private UserRepository userRepository;

    public PublicRestApiController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("test1")
    public String index(){
        return "testing 1";
    }

    @GetMapping("test2")
    public String index2(){
        return "API Test 2";
    }


    @GetMapping("users")
    public List<User> users(){
        return this.userRepository.findAll();
    }
}

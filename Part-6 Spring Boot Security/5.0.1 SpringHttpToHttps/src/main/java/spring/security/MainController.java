package spring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Created 22 / 04 / 2020 - 3:43 PM
 * @project SpringHttpToHttps
 * @Author Hamdamboy
 */

@Controller
@RequestMapping("")
public class MainController {

    @GetMapping("index")
    public String index(){
        return "index";
    }

}

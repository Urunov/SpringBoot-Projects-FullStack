package controller;

import org.junit.runner.RunWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

@RunWith(SpringRunner.class)

@Controller
public class TacoController {

    @GetMapping("/")
    public String home() {
        return "index";
    }


}

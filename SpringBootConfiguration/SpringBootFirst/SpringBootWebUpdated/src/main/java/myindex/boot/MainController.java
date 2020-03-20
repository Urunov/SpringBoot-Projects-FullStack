package myindex.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class MainController {
    //
   // @RequestMapping(value = "/we")\
    @GetMapping("/we")
    public String showMe() {
        return "core";
    }
}

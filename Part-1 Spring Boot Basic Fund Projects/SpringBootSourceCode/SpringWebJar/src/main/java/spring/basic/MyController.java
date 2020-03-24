package spring.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;

/**
 * @Created 23 / 03 / 2020 - 2:41 PM
 * @project SpringWebJar
 * @Author Hamdamboy
 */

@Controller
public class MyController {
    //

    @GetMapping("/app")
    public String index(Model model) {
        model.addAttribute("dateTime", LocalDateTime.now());
        return "index";
    }
}

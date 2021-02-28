package spring.jsp;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @Created 19 / 05 / 2020 - 4:25 PM
 * @project SpringBootJSP
 * @Author Hamdamboy
 */
@org.springframework.stereotype.Controller
public class Controller {


    private static final String message = "Hello World Hamdamboy  Urunov";

    @GetMapping(value = "/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "index";
    }
}

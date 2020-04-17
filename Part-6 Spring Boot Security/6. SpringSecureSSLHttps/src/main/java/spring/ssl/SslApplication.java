package spring.ssl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SslApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SslApplication.class, args);
    }


    @GetMapping("/")
    public String index(final Model model)
    {
        model.addAttribute("title", "Spring Boot + SSL (HTTPS)");
        model.addAttribute("msg", "Welcome to the SSL");

        return "index";
    }


}

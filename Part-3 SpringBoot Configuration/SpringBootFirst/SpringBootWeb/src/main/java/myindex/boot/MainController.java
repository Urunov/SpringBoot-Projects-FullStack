package myindex.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
@Author: Hamdamboy
@Date: 03.03.2020
----------------------------------------
Specification value of the Spring Boot

*  Spring Boot has 2 kind of different @Annotation
*  - @Controller
*  - @RestController
*  then inside the class:
*  - @RequestMapping
*  - @GetMapping
*
*   #1. The same result when you launch (debug) file using .html
*  @Controller
*  @GetMapping
*    \when resource/template/ --> add your html file (index.html)
    localhost:8080/ --> is working
    ==> Using :  thymeleaf (dependence Maven_)
*  # 2. JSP file cannot work the same way

   #3. RequestMapping and GetMapping

https://www.reddit.com/
https://www.onlineinterviewquestions.com/what-is-the-difference-between-requestmapping-and-getmapping-in-spring-boot/
* */

@Controller

public class MainController {
    //
    @GetMapping("/we")
    public String BizAgain() {
        return "index";
    }
}
package spring.swagger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: apple
 * @created on 04/04/2020
 * @Project is SpringSwagger2
 */

@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
    public String Hello(){
        return "Spring Swagger2";
    }
}

package spring.swagger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created 03 / 04 / 2020 - 3:21 PM
 * @project SpringSwaggerBeginner
 * @Author Hamdamboy
 */

@RestController
public class SpringSwaggerController {
    //
    @RequestMapping(method = RequestMethod.GET, value = "/api/aspera")
    public String File(){

        return "Spring Swagger File ";
    }

    @PostMapping(value = "/api/aspera")
    public String UpdateFile(){
       return "Spring Update Files";
    }


}

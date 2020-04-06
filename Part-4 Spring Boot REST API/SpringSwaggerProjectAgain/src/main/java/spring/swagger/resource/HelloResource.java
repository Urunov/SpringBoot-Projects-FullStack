package spring.swagger.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

/**
 * @Created 06 / 04 / 2020 - 9:54 AM
 * @project SpringSwaggerProjectAgain
 * @Author Hamdamboy
 */

@RestController
@RequestMapping("/rest/hello")
@Api(value = "HelloWorld Resource", description = "show hello world")
public class HelloResource {
    //
    @ApiOperation(value = "return Hello world")
    @ApiResponses(
            value = {
                    @ApiResponse(code =100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful Hello world")
            }
    )

    @GetMapping
    public String hello(){
        return "Hello World";
    }

    @ApiOperation(value = "Return Hello World")
    @PostMapping("/post")
    public String helloPost(@RequestBody final String hello){
        return hello;
    }

    @ApiOperation(value = "Return Hello World")
    @PutMapping("/put")
    public String helloPut(@RequestBody final String hello) {
        return hello;
    }



}

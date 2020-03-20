package spring.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ControllerSpring {
    //

    private static final String template = "Hello, %s !";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hey")
    public HelloSpring Greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
            return new HelloSpring(counter.incrementAndGet(), String.format(template, name));
    }
}

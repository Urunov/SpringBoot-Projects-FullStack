package spring.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {

       ApplicationContext springMVC =  SpringApplication.run(BasicApplication.class, args);

        SpringStand ss = springMVC.getBean(SpringStand.class);
        ss.Stand();
    }

}

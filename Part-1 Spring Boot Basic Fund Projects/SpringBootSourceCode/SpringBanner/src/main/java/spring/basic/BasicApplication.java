package spring.basic;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {

        //SpringApplication.run(BasicApplication.class, args);
        SpringApplication springApplication = new SpringApplication(BasicApplication.class);
        springApplication.run(args);
        springApplication.setBannerMode(Banner.Mode.OFF);

    }

}


// http://boraji.com/spring-boot-configurationproperties-example
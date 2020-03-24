package spring.basic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BasicApplication {

    private static Logger logger = LogManager.getLogger(BasicApplication.class);

    public static void main(String[] args) {


        logger.info("Spring Boot Log is able to display");
        SpringApplication.run(BasicApplication.class, args);


    }

}

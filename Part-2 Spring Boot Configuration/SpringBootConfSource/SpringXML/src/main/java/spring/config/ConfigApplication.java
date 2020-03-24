package spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import spring.config.service.MessageProcessor;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class ConfigApplication {

    public static void main(String[] args) {

      ApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);

        MessageProcessor userService = applicationContext.getBean(MessageProcessor.class);
        userService.processMsg("twitter message sending ");
    }

}

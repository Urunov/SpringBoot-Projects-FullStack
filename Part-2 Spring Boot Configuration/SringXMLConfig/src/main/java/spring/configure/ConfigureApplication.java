package spring.configure;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import spring.configure.service.MessageProcessor;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class ConfigureApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ConfigureApplication.class, args);

        MessageProcessor userService = applicationContext.getBean(MessageProcessor.class);
        userService.processMsg("twitter message sending ");
    }
}

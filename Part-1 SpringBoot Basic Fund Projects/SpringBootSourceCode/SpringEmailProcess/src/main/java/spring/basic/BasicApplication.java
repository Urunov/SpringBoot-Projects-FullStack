package spring.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(MailProperties.class)
public class BasicApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BasicApplication.class, args);
        MailService mailService = context.getBean(MailService.class);
        mailService.print();
    }

}

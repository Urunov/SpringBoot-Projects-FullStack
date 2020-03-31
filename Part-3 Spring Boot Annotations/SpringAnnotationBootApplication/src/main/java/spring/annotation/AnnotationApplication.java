package spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/** @SpringBootApplication
 *  Annotation indicates a configuration class that declares one or more @Bean methods, and
 *  also trigger auto-configuration and component scanining. This is a convenience annotation
 *  that is equivalent to declaring @Configuration, @EnableAutoConfiguration, and @ComponentScan
 *
 * @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan.
 *
 * @EnableAutoConfiguration - enable Spring Boot's auto-configuration mechanism
 * @CompoenetScan - enable @Component scan on the package where the application is located.
 * @Configuration - allow to register extra beans in the context or import additional configuration classes.
 * **/
@Configuration
@EnableAutoConfiguration
@ComponentScan

public class AnnotationApplication {
    @Autowired
    private MyConfig myConfig;
    public static void main(String[] args) {
        SpringApplication.run(AnnotationApplication.class, args);
        MyConfig myConfig = new MyConfig();

        // Setting value in the each variable in the system
        myConfig.setIdentity("1122");
        myConfig.setTitle("My Cognitive control Annotation. (dev.to/hamdamboy)");

        System.out.println(myConfig.show());
        System.out.println(myConfig.getIdentity());
        System.out.println(myConfig.getTitle());

    }



}

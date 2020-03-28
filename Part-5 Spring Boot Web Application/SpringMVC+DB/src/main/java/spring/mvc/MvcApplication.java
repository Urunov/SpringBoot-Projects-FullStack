package spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class MvcApplication implements WebApplicationInitializer {



    public static void main(String[] args)  {
        SpringApplication.run(MvcApplication.class, args);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }
}

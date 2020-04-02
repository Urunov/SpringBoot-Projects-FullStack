package spring.jersey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @Created 02 / 04 / 2020 - 11:24 AM
 * @project SpringJerseySimple
 * @Author Hamdamboy
 */
@SpringBootApplication
public class JerseyApplication implements WebApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JerseyApplication.class, args);
    }

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        sc.setInitParameter("contextConfigLocation", "noop");

        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        sc.addListener(new ContextLoaderListener(context));
        sc.addListener(new RequestContextListener());
    }
}

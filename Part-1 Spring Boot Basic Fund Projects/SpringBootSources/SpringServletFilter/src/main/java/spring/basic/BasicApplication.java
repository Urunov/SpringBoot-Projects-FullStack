package spring.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import java.io.IOException;

@SpringBootApplication
public class BasicApplication {

    // Register Servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return bean;
    }

    // Register Filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean((Filter) new MyFilter());
        // Mapping filter to a Servlet
        bean.addServletRegistrationBeans(new ServletRegistrationBean[] {
                servletRegistrationBean()
        });
        return bean;
    }

    // Register ServletContextListener
    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean() {
        ServletListenerRegistrationBean<ServletContextListener> bean =
                new ServletListenerRegistrationBean<>();
        bean.setListener(new MyServletContextListener());
        return bean;

    }

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

}

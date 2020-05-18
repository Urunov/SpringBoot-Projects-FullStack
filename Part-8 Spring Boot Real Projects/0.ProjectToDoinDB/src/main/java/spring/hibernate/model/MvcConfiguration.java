package spring.hibernate.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @Created 18 / 05 / 2020 - 5:36 PM
 * @project ProjectTodo
 * @Author Hamdamboy
 */

//@Configuration
//@EnableWebMvc
//@ComponentScan
//public class MvcConfiguration extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/view/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        registry.viewResolver(resolver);
//    }
//}


 //https://htr3n.github.io/2018/12/jsp-spring-boot/
 // https://howtodoinjava.com/spring-boot/spring-boot-jsp-view-example/
package spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Created 08 / 04 / 2020 - 5:44 PM
 * @project SpringMultipleDataStructure
 * @Author Hamdamboy
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    //

    @Bean
    public OpenEntityManagerInViewFilter securityOpenEntityManagerInViewFilter()
    {
        OpenEntityManagerInViewFilter osivFilter = new OpenEntityManagerInViewFilter();
        osivFilter.setEntityManagerFactoryBeanName("securityEntityManagerFactory");
        return osivFilter;
    }

    @Bean
    public OpenEntityManagerInViewFilter ordersOpenEntityManagerInViewFilter()
    {
        OpenEntityManagerInViewFilter osivFilter = new OpenEntityManagerInViewFilter();
        osivFilter.setEntityManagerFactoryBeanName("ordersEntityManagerFactory");
        return osivFilter;
    }
}

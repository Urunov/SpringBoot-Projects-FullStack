package spring.basic;

/**
 * @Created 23 / 03 / 2020 - 4:16 PM
 * @project SpringServletFilter
 * @Author Hamdamboy
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener  {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("MyServletContextListener Context Initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("MyServletContextListener Context Destroyed");
    }
}

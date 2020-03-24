package spring.basic;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Filter;
import java.util.logging.LogRecord;


/**
 * @Created 23 / 03 / 2020 - 4:20 PM
 * @project SpringServletFilter
 * @Author Hamdamboy
 */
public class MyFilter implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  throws IOException, ServletException {

        System.out.println("MyFilter doFilter() is invoked.");
        Enumeration<String> params = request.getAttributeNames();
        while (params.hasMoreElements()){
            String param = params.nextElement();
            System.out.println("Parameters: " + param + "\tValue: "+ request.getParameter(param));
        }
        chain.doFilter(request, response);
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
    //




}

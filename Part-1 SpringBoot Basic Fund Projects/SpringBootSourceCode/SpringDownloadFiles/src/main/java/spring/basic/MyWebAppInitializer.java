package spring.basic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Created 23 / 03 / 2020 - 10:19 AM
 * @project SpringDownloadFile
 * @Author Hamdamboy
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

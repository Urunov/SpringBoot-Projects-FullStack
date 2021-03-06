package spring.custom;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Created 21 / 04 / 2020 - 4:29 PM
 * @project custom
 * @Author Hamdamboy
 */
@Configuration
@EnableConfigurationProperties
public class HttpsConfiguration {

    @Bean
    public ServletWebServerFactory servletContainer(){
        // Enable SSL Traffic
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };

        // Add HTTP to HTTPS redirect
        tomcat.addAdditionalTomcatConnectors(httpToHttpRedirectConnector());
        return tomcat;
    }
    /*
     *  We need redirect from HTTP to HTTPS. Without SSL, this application used port 8082. With SSL it will use port 8443.
     *  SO, any request for 8082 needs to be redirected to HTTPS on 8443.
     * */
    @Value("${server.port.http}")
    private int serverPortHttp;

    @Value("${server.port}")
    private int serverPortHttps;

    private Connector httpToHttpRedirectConnector(){
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(serverPortHttp);
        connector.setSecure(false);
        connector.setRedirectPort(serverPortHttps);
        return connector;
    }
}

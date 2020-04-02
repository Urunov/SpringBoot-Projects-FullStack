package spring.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.web.filter.RequestContextFilter;

import javax.ws.rs.ApplicationPath;



/**
 * @Created 02 / 04 / 2020 - 2:57 PM
 * @project SpringJerseySimple
 * @Author Hamdamboy
 */

@ApplicationPath("/api/")
public class AppConfig extends ResourceConfig {
    //

    public AppConfig(){
        packages("spring.jersey.resource");
        register(RequestContextFilter.class);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
    }


}

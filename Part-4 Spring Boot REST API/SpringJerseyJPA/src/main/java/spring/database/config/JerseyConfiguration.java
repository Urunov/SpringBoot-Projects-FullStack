package spring.database.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import spring.database.controller.JobResource;

import javax.ws.rs.ApplicationPath;
/**
 * @Author: apple
 * @created on 01/04/2020
 * @Project is SpringJerseyJPA
 */
@Component
@ApplicationPath("/boot-jersey")
public class JerseyConfiguration extends ResourceConfig {
    //
    public JerseyConfiguration(){
        register(JobResource.class);
    }
}

package uz.bepro.springjwtsecure.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @project: spring-jwt-secure
 * @Date: 18.08.2022
 * @author: H_Urunov
 **/
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {
    //
    private String secretKey;
    private String tokenPrefix;
    private String tokenExpirationAfterDays;

    public JwtConfig(){


    }
}

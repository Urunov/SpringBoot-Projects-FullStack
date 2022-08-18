package uz.bepro.springjwtsecure.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

/**
 * @project: spring-jwt-secure
 * @Date: 18.08.2022
 * @author: H_Urunov
 **/
@Configuration
public class JwtSecretKey {
    //
    private final JwtConfig jwtConfig;

    @Autowired
    public JwtSecretKey(JwtConfig jwtConfig){
        this.jwtConfig = jwtConfig;
    }

    @Bean
    public SecretKey getSecretKeyForSigning(){
        return Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());

    }
}

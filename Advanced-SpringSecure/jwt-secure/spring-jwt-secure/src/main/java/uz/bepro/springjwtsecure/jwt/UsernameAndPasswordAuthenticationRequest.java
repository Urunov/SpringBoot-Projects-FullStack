package uz.bepro.springjwtsecure.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.crypto.SecretKey;

/**
 * @project: spring-jwt-secure
 * @Date: 18.08.2022
 * @author: H_Urunov
 **/
@Getter
@Setter
@NoArgsConstructor
public class UsernameAndPasswordAuthenticationRequest {
    //
    private String username;
    private String password;

    public UsernameAndPasswordAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

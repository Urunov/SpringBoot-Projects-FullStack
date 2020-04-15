package spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}

/***
 *   Simple handler with Security using, temporarly using security password:
 *   ----------------------------------------------------------------------
 *   Format:
 *   Using generated security password: d26ac686-c619-4dac-a810-0e5daadf2dd0
 *   ----------------------------------------------------------------------
 *   Only adding this dependency and using security generated password on the browser,
 *   regularly, user name is (user or admin).
 *
 *   login: user
 *   password: d26ac686-c619-4dac-a810-0e5daadf2dd0
 *
 *   --------------------------------------------------------------------------
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-security</artifactId>
 *         </dependency>
 *
 *
 * */
package spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Created 22 / 04 / 2020 - 3:43 PM
 * @project SpringHttpToHttps
 * @Author Hamdamboy
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

         auth
         .inMemoryAuthentication()
         .withUser("admin")
         .password(passwordEncoder().encode("admin123"))
         .roles("ADMIN");
    }

    /**
     * Enable HTTPS/SSL in Spring Boot
     * **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                //  .anyRequest().permitAll() if you fix all permission values, then remove all conditions.
                .antMatchers("/index").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .httpBasic();

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

package spring.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Created 16 / 04 / 2020 - 11:53 AM
 * @project security
 * @Author Hamdamboy
 */

@EnableWebSecurity
@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN").authorities("ACCESS_TEST1", "ACCESS_TEST2")
                .and()
                .withUser("hamdamboy")
                .password(passwordEncoder().encode("hamdamboy123"))
                .roles("USER")
                .and()
                .withUser("manager")
                .password(passwordEncoder().encode("manager"))
                .roles("MANAGER")
                .authorities("ACCESS_TEST1");
    }

    /**
     *
     * **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                //  .anyRequest().permitAll() if you fix all permission values, then remove all conditions.
                .antMatchers("/index.html").permitAll()
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
                .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
                .and()
                .httpBasic();

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

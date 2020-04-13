package spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @Created 10 / 04 / 2020 - 11:38 AM
 * @project SpringSecuritySimpleExample
 * @Author Hamdamboy
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    // role admin allow to access / admin/**
    //roles user allow to access /user/**
    // custom 403 access denied handler

    @Override
    protected void configure(HttpSecurity http) throws Exception{

                http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home**", "/about**").permitAll()
                .antMatchers("/user/**").hasAnyRole("USER")
                        .antMatchers("/admin").access("hasAnyAuthority('ADMIN')")

                .anyRequest().authenticated()
              .and()
              .formLogin()
              .loginPage("/login")
                .permitAll()
                .and()
              .logout()
              .permitAll()
              .and()
              .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
//        http
//                .csrf().disable()
//                .authorizeRequests()
//
//                .antMatchers("/login**", "/").permitAll()
//                .antMatchers("/user/**").access("hasAnyAuthority('USER')")
//                .antMatchers("/admin/**").access("hasAnyAuthority('ADMIN')")
//
//                .anyRequest().fullyAuthenticated()
//                .and()
//                .formLogin();
//

    }

    // Create two users, admin and user
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("12345").roles("USER")
                .and()
                .withUser("admin").password("admin12345").roles("ADMIN");
    }
}

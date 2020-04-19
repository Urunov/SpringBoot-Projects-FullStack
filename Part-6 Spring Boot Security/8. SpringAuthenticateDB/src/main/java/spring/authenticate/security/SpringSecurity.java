package spring.authenticate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Created 16 / 04 / 2020 - 3:36 PM
 * @project SpringHTTPSecurity
 * @Author Hamdamboy
 */

@EnableWebSecurity
@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter {


    private UserPrincipalDetialService userPrincipalDetialService;

    public SpringSecurity(UserPrincipalDetialService userPrincipalDetialService){
        this.userPrincipalDetialService = userPrincipalDetialService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)  {

        auth.authenticationProvider(authenticationProvider());


        /***
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin123"))

                .roles("ADMIN").authorities("ACCESS_TEST1", "ACCESS_TEST2", "ROLE_ADMIN")
                .and()
                .withUser("hamdamboy")
                .password(passwordEncoder().encode("hamdamboy123"))
                .roles("USER")
                .and()
                .withUser("manager")
                .password(passwordEncoder().encode("manager123"))
                .roles("MANAGER")
                .authorities("ACCESS_TEST1", "ROLE_MANAGER");
        ***/


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
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
                .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
                .antMatchers("/api/public/users").hasAuthority("ADMIN")
                .and()
                .httpBasic();

    }

//    @Bean
//    UserDetailsService userDetailsService(){
//        return UserPrincipalDetialService();
//    }


    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetialService);

        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

package com.secure.sytem.securestart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.secure.sytem.securestart.security.ApplicationUserPermission.COURSE_WRITE;
import static com.secure.sytem.securestart.security.ApplicationUserRole.*;

/**
 * @project: secure-start
 * @Date: 12.08.2022
 * @author: H_Urunov
 **/
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    //
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(COURSE_WRITE.name())
                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.name())
                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(COURSE_WRITE.name())
                .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        // Permission User(s)
        UserDetails urunovUser =
                User.builder()
                        .username("urunov")
                        .password(passwordEncoder.encode("urunov1987"))
                        .authorities("STUDENT")
 //                       .authorities(STUDENT.getGrantedAuthorities())
//                        .roles(STUDENT.name()) // ROLE_STUDENT
                        .build();

        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("linda333"))
                .authorities("ADMIN")
 //               .authorities(ADMIN.getGrantedAuthorities())
//                .roles(ADMIN.name()) // ROLE_ADMIN
                .build();

        UserDetails tomUser = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("tom555"))
                .authorities("ADMINTRAINEE")
//                .authorities(ADMINTRAINEE.getGrantedAuthorities())
//                .roles(ADMINTRAINEE.name()) // ROLE ADMINTRAINEE
                .build();

        UserDetails hotamboyUser = User.builder()
                .username("hotam")
                .password(passwordEncoder.encode("hotamboy"))
                .build();

        return new InMemoryUserDetailsManager( // manage user(s)
                lindaUser,
                urunovUser,
                tomUser,
                hotamboyUser
        );


    }
}
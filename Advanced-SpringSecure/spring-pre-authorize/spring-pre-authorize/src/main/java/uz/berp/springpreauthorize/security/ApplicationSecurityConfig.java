package uz.berp.springpreauthorize.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static uz.berp.springpreauthorize.security.ApplicationUserRole.*;


/**
 * @project: secure-start
 * @Date: 12.08.2022
 * @author: H_Urunov
 **/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
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
                // simple auth api purpose
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(ADMIN.name()) // managing role here based on enum categories.
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
}

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
            // Permission User(s)
            UserDetails urunovUser = User.builder()
                        .username("urunov")
                        .password(passwordEncoder.encode("urunov1987"))
                        //.roles(ADMIN.name()) // ROLE_STUDENT
                        .authorities(STUDENT.getGrantedAuthorities())
                        .build();

            UserDetails lindaUser = User.builder()
                    .username("linda")
                    .password(passwordEncoder.encode("linda333"))
                    .authorities(STUDENT.name())
                    //.roles(STUDENT.name()) // ROLE_ADMIN
                    .authorities(ADMIN.getGrantedAuthorities())
                    .build();

            UserDetails tomUser = User.builder()
                    .username("tom")
                    .password(passwordEncoder.encode("tom555"))
                    .authorities(ADMINTRAINEE.name())
                    .authorities(ADMINTRAINEE.getGrantedAuthorities())
              //      .roles(ADMINTRAINEE.name()) // ROLE ADMINTRAINEE
                    .build();

            UserDetails tolik = User.builder()
                    .username("tolik")
                    .password(passwordEncoder.encode("tolik1"))
                    .authorities(STUDENT.name())
                    .authorities(ADMIN.getGrantedAuthorities())
                    .build();

            UserDetails hotamboyUser = User.builder()
                    .username("hotam")
                    .password(passwordEncoder.encode("hotamboy"))
                    .authorities(ADMIN.name())
                    .authorities(ADMIN.getGrantedAuthorities())
                //    .roles(ADMIN.name()) // ROLE ADMIN
                    .build();

            return new InMemoryUserDetailsManager(
                    urunovUser,
                    lindaUser,
                    tomUser,
                    hotamboyUser,
                    tolik
        );
    }
}
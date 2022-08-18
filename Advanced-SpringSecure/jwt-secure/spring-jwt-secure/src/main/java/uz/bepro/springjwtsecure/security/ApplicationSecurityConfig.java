package uz.bepro.springbaseauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import uz.bepro.springjwtsecure.jwt.JwtTokenVerifier;
import uz.bepro.springjwtsecure.jwt.JwtUsernameAndPasswordAuthenticationFilter;

import static uz.bepro.springbaseauth.security.ApplicationUserRole.*;


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
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, jwtSecretKey))
                .addFilterAfter(new JwtTokenVerifier(), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(ADMIN.name()) // managing role here based on enum categories.
                .anyRequest()
                .authenticated();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
            // Permission User(s)
            UserDetails urunovUser = User.builder()
                        .username("urunov")
                        .password(passwordEncoder.encode("urunov1987"))
                        .roles(ADMIN.name()) // ROLE_STUDENT
                        .build();

            UserDetails lindaUser = User.builder()
                    .username("linda")
                    .password(passwordEncoder.encode("linda333"))
                    .authorities(STUDENT.name())
                    .roles(STUDENT.name()) // ROLE_ADMIN
                    .build();

            UserDetails tomUser = User.builder()
                    .username("tom")
                    .password(passwordEncoder.encode("tom555"))
                    .authorities(ADMINTRAINEE.name())
              //      .authorities(ADMINTRAINEE.getGrantedAuthorities())
                    .roles(ADMINTRAINEE.name()) // ROLE ADMINTRAINEE
                    .build();
//
            UserDetails hotamboyUser = User.builder()
                    .username("hotam")
                    .password(passwordEncoder.encode("hotamboy"))
                    .authorities(ADMIN.name())
                 //   .authorities(ADMIN.getGrantedAuthorities())
                    .roles(ADMIN.name()) // ROLE ADMIN
                    .build();

            return new InMemoryUserDetailsManager(
                    urunovUser,
                    lindaUser,
                    tomUser,
                    hotamboyUser

        );

    }
}
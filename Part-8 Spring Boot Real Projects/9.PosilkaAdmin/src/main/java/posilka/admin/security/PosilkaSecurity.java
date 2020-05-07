package posilka.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * @Created 06 / 05 / 2020 - 12:09 PM
 * @project AdminPage
 * @Author Hamdamboy
 */
@Configuration
@EnableWebSecurity
public class PosilkaSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
                .and()
                .withUser("hamdamboy").password(passwordEncoder().encode("dam123")).roles("USER");

    }

    /**
     *  This is Http security, consists of all incoming requests.
     * **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .formLogin()
                .loginPage("/login.html").loginProcessingUrl("/login").permitAll();
        http
                .logout()
                .logoutUrl("/logout");
        http
                .csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .httpBasic();

              /*  .authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/admin/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .httpBasic();

               */
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

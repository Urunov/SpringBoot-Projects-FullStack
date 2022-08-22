package uz.bepro.jwtsecurity.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @project: jwt-security
 * @Date: 19.08.2022
 * @author: H_Urunov
 **/
@Service
public class JwtUserDetailsService implements UserDetailsService {
    //
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("urunov".equals(username)) {
            return new User("urunov", "$2a$10$BsWqJ0Pju0Iogadc3am48OSNA9Z7tOlfO98X02xefL4Ymq4iHB.fe",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}

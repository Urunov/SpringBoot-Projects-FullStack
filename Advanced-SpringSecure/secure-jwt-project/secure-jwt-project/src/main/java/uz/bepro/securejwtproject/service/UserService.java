package uz.bepro.securejwtproject.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @project: secure-jwt-project
 * @Date: 19.08.2022
 * @author: H_Urunov
 **/

@Service
public class UserService implements UserDetailsService {
    //

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Logic to get the user from the Database.

        return new User("admin", "admin", new ArrayList<>());
    }
}

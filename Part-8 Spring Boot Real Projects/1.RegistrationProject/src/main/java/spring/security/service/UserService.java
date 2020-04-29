package spring.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import spring.security.repisitory.UserRegistrationDto;

/**
 * @Created 29 / 04 / 2020 - 4:37 PM
 * @project SpringRegistor
 * @Author Hamdamboy
 */


public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}

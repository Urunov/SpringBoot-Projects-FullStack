package spring.sample.registration.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import spring.sample.registration.controller.dto.UserRegistrationDto;
import spring.sample.registration.model.User;


/**
 * @Created 29 / 06 / 2020 - 6:47 PM
 * @project RegistrationPerson
 * @Author Hamdamboy
 */
public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
}

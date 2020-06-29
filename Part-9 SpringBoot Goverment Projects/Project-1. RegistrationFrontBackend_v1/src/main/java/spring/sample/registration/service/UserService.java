package spring.sample.registration.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import spring.sample.registration.model.User;
import spring.sample.registration.web.dto.UserRegistrationDto;

/**
 * @Created 29 / 06 / 2020 - 6:47 PM
 * @project RegistrationPerson
 * @Author Hamdamboy
 */
public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);


}

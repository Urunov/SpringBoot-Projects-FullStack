package aspera.registration.service;

import aspera.registration.model.User;
import aspera.registration.web.dto.UserRegistrationDto;

import org.springframework.security.core.userdetails.UserDetailsService;
/**
 * @Created 02 / 06 / 2020 - 2:09 PM
 * @project SpringRegistration
 * @Author Hamdamboy
 */

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}

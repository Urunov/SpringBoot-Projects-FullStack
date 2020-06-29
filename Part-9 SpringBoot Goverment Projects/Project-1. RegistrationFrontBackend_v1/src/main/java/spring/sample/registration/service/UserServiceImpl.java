package spring.sample.registration.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.sample.registration.model.Role;
import spring.sample.registration.model.User;
import spring.sample.registration.repository.UserRepository;
import spring.sample.registration.web.dto.UserRegistrationDto;

import java.util.Arrays;

/**
 * @Created 29 / 06 / 2020 - 6:50 PM
 * @project RegistrationPerson
 * @Author Hamdamboy
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

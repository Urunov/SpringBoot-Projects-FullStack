package spring.custom.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.custom.dao.UserRepository;
import spring.custom.model.User;

/**
 * @Created 21 / 04 / 2020 - 11:13 AM
 * @project custom
 * @Author Hamdamboy
 */

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user  = this.userRepository.findByUsername(s);
        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }
}

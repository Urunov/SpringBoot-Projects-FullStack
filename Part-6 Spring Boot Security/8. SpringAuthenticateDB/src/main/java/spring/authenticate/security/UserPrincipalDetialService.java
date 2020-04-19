package spring.authenticate.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.authenticate.db.UserRepository;
import spring.authenticate.model.User;


/**
 * @Created 17 / 04 / 2020 - 4:12 PM
 * @project SpringAuthenticateDB
 * @Author Hamdamboy
 */
@Service
public class UserPrincipalDetialService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipalDetialService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);
        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }


}

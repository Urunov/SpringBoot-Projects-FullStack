package spring.security.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.security.dao.UserRepository;
import spring.security.model.User;

/**
 * @Created 13 / 04 / 2020 - 10:22 AM
 * @project SpringSecurityForm
 * @Author Hamdamboy
 */
@Service
public class UserPrincipalDetailsService implements UserDetailsService {

   private UserRepository userRepository;

   public UserPrincipalDetailsService(UserRepository userRepository){
       this.userRepository = userRepository;
   }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);
        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }

    //

}

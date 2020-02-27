package service;

import entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
    //

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //
        User user = repo.findByUsername(username);
        if(user==null)
               throw new UsernameNotFoundException("User 404");

            return new UserPrincipal(user);
    }
}


// https://www.youtube.com/watch?v=2VKeCZsRNZk&list=PLsyeobzWxl7o-Ul7lhFb9-fLjDYapcetO&index=5
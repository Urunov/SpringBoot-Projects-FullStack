package com.urunov.controller;

import com.urunov.payload.UserIdentityAvailability;
import com.urunov.payload.UserSummary;
import com.urunov.repository.UserRepository;
import com.urunov.security.CurrentUser;
import com.urunov.security.UserPrincipal;
import com.urunov.service.UserService;
import com.urunov.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER'")")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser)
    {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),currentUser.getSurname(), currentUser.getName(), currentUser.getLastname(), currentUser.getCity());
        return userSummary;
    }

    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username){
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }




}

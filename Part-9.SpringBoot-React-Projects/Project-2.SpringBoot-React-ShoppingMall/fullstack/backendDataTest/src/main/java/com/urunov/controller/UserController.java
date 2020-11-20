package com.urunov.controller;

import com.urunov.exception.ResourceNotFoundException;
import com.urunov.model.User;
import com.urunov.payload.UserIdentityAvailability;
import com.urunov.payload.UserProfile;
import com.urunov.payload.UserSummary;
import com.urunov.repository.UserRepository;
import com.urunov.security.CurrentUser;
import com.urunov.security.UserPrincipal;
import com.urunov.service.UserService;
import com.urunov.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser)
    {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),currentUser.getSurname(), currentUser.getName(), currentUser.getLastname(), currentUser.getCity());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username)
    {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvialability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email)
    {

        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @PostMapping("/users/getBySearch")
    public Optional<User> getUserBySearch(@RequestParam(value = "username") String username)
    {
        return userRepository.findByUsername(username);
    }

    @GetMapping("/users/getAllUsers")
    public List<String> getAllUsers(@PathVariable(value = "id") Long id)
    {
        return userRepository.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserProfile getUserProfile(@PathVariable(value = "id") Long id)
    {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User", "username", id));
        UserProfile userProfile = new UserProfile(user.getId(), user.getSurname(), user.getName(), user.getLastname(), user.getUsername(), user.getCreatedAt(), user.getPhone(), user.getEmail(), user.getPassword(), user.getCity());
        userUtils.initUserAvatar(userProfile, user);
        return userProfile;
    }

    @PostMapping("/users/saveUserProfile")
    public ResponseEntity<?> saveUserProfile(@CurrentUser UserPrincipal userPrincipal, @RequestBody UserProfile userProfileForm)
    {
        return userService.saveUserProfile(userPrincipal, userProfileForm);
    }

    @PostMapping("/users/saveCity")
    public Boolean saveCity(@CurrentUser UserPrincipal userPrincipal, @RequestBody String city)
    {
        return userService.saveCity(userPrincipal, city);
    }


}

package com.urunov.service;

import com.urunov.model.User;
import com.urunov.payload.ApiResponse;
import com.urunov.payload.UserProfile;
import com.urunov.repository.UserRepository;
import com.urunov.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> saveUserProfile(UserPrincipal userPrincipal, UserProfile userProfileForm){

        Optional<User> userDto = userRepository.findById(userPrincipal.getId());
        User user = userDto.orElse(null);

        if(user !=null && user.getPhone().equals(userProfileForm.getPhone()) && userRepository.existsByPhone(userProfileForm.getPhone()))
            return new ResponseEntity<>(
                    new ApiResponse(false, "Please, you may show phone number for register!, Or show other number"),
                    HttpStatus.BAD_REQUEST);

        if(user != null && user.getEmail() !=null && !user.getEmail().equals(userProfileForm.getEmail()) && userRepository.existsByEmail(userProfileForm.getEmail()))
            return new ResponseEntity<>(
                    new ApiResponse (false, "Please email you may register, or different one."),
                    HttpStatus.BAD_REQUEST);

        if (user != null)
        {
            user.setSurname(userProfileForm.getSurname());
            user.setName(userProfileForm.getName());
            user.setLastname(userProfileForm.getLastname());
            user.setEmail(userProfileForm.getEmail());
            user.setPhone(userProfileForm.getPhone());
            userRepository.save(user);
            return new ResponseEntity<>(new ApiResponse(true, "change already saved"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    new ApiResponse(false, "Oops, issues! Please update page!"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    public Boolean saveCity(UserPrincipal userPrincipal, String city){
        Optional<User> userDto = userRepository.findById(userPrincipal.getId());
        User user = userDto.orElse(null);
        if(user!= null) {
            user.setCity(city);
            userRepository.save(user);
            return true;
        }
        else{
            return false;
        }
    }
}

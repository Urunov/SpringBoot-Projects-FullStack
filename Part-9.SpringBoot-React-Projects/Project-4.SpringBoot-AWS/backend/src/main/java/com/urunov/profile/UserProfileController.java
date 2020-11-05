package com.urunov.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@RestController
@RequestMapping("api/v1/user-profile")
@CrossOrigin("*")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;


    @GetMapping("/")
    public List<UserProfile> getUserProfiles(){
        return userProfileService.getUserProfiles();
    }

    @PostMapping()
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file) throws Exception{

       userProfileService.uploadUserProfileImage(file.getName(), file);

        return ResponseEntity.ok("okay");
    }
}

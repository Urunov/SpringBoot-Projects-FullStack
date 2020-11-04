package com.urunov.aws.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Service
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;


    @Autowired
    public UserProfileService(UserProfileDataAccessService userProfileDataAccessService) {
        this.userProfileDataAccessService = userProfileDataAccessService;
    }


    List<UserProfile> getUserProfiles(){
        return userProfileDataAccessService.getUserProfile();
    }

}


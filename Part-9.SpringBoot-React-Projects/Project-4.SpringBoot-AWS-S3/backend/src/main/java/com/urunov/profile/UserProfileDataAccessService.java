package com.urunov.profile;

import com.urunov.datastore.FakeUserProfileDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Repository
public class UserProfileDataAccessService {


    FakeUserProfileDataStore fakeUserProfileDataStore;

    List<UserProfile> getUserProfile(){
        return fakeUserProfileDataStore.getUserProfiles();
    }


}

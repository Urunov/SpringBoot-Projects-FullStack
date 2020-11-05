package com.urunov.datastore;

import com.urunov.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Repository
public class FakeUserProfileDataStore {

    private static final LinkedList<UserProfile> USER_PROFILES = new LinkedList<UserProfile>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID().toString(), "urunov", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID().toString(), "hamdamboy", null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }

}

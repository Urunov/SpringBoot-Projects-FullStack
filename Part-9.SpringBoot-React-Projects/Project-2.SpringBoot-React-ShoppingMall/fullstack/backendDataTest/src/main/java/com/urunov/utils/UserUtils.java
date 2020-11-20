package com.urunov.utils;

import com.urunov.model.User;
import com.urunov.payload.UserProfile;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Component
public class UserUtils
{

  public void initUserAvatar(UserProfile userProfile, User user){

      if(user.getAvatar() !=null){
          userProfile.setAvatarImgUrl(new String(Base64.decodeBase64(user.getAvatar()), StandardCharsets.UTF_8));
      }
  }
}

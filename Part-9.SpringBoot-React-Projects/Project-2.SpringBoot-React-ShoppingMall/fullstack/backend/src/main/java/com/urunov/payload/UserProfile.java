package com.urunov.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.Instant;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Data
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Instant avatarImgUrl;

    private String surname;
    private String name;
    private String lastname;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String city;



}

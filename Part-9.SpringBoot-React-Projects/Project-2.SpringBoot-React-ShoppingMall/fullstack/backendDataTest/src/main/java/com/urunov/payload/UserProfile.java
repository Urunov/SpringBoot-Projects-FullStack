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
    private Instant joinedAt;

    @JsonIgnore
    private String avatarImgUrl;

    private String surname;
    private String name;
    private String lastname;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String city;

    public UserProfile(Long id, String surname, String name, String lastname, String username, Instant createdAt, String phone, String email, String password, String city) {

        this.id = id;
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.joinedAt = createdAt;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.city = city;
    }
}

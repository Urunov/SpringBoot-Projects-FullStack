package com.urunov.profile;

import lombok.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserProfile {

    private String userProfileId;
    private String username;
    private String userProfileImageLink;  /**S3 key */
}



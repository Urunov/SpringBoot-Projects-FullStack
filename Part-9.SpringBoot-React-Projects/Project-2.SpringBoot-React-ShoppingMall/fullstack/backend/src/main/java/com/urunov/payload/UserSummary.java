package com.urunov.payload;

import lombok.*;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserSummary {

    private Long id;
    private String username;
    private String surname;
    private String name;
    private String lastname;
    private String city;

    public UserSummary(Long id, String username, String name){
        this.id = id;
        this.username = username;
        this.name = name;
    }


//    public UserSummary(Long id, String username, String surname, String name, String lastname, String city) {
//        this.id = id;
//        this.username = username;
//        this.surname = surname;
//        this.name = name;
//        this.lastname = lastname;
//        this.city = city;
//    }
}

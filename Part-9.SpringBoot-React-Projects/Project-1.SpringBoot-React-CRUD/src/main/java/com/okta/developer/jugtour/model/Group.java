package com.okta.developer.jugtour.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author: apple
 * @created on 13/07/2020
 * @Project is SpringReactCrud
 */

@Data
@NoArgsConstructor
@Entity
@Table(name="user_group")
public class Group {

    @Id
    @GeneratedValue
    private Long id;
    
    @NonNull
    private String name;
    private String address;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events;

}

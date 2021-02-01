package com.urunov.entity.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.entity.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private String office;

    private String mobile;

    private String other;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "contactInfo")
    @JsonIgnore
    private List<BankInfo> banks;

    // Customer OneToOne
    @OneToOne(mappedBy = "contactInfo")
    @JsonIgnore
    private Customer customer;


}

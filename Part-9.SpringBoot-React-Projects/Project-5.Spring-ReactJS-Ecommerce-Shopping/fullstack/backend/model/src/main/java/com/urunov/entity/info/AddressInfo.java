package com.urunov.entity.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.entity.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class AddressInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstLine;

    private String secondLine;

    private String zipCode;

    private String state;

    private String country;


    @OneToOne(mappedBy = "addressInfo")
    @JsonIgnore
    private OrderInfo order;

    // Bank
    @OneToMany(mappedBy = "addressInfo", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BankInfo> banks;

    // Customer
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;


}

package com.urunov.entity.elements.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@NoArgsConstructor
@ToString
@Entity
public class AddressInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstLine;

    private String secondLine;

    private String zipCode;

    private String state;

    private String country;



    @OneToOne(mappedBy = "addressInfo")
    private OrderInfo order;

    // Bank
//    @OneToMany(mappedBy = "addressInfo", orphanRemoval = true, cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<BankInfo> banks;


}

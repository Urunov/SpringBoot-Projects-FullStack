package com.urunov.entity.info;

import lombok.*;

import javax.persistence.*;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class BankInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int customerId;

    private int sellerId;

    private String firstName;

    private String lastName;

    private String bankName;

    private String routingNumber;

    private String accountNumber;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id")
//    private AddressInfo addressInfo;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "contact_id")
//    private ContactInfo contactInfo;

}

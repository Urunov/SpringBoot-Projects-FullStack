package com.urunov.entity.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.entity.info.AddressInfo;
import com.urunov.entity.info.BankInfo;
import com.urunov.entity.info.ContactInfo;
import com.urunov.entity.info.OrderInfo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * User: hamdamboy
 * Project: security
 * Github: @urunov
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String image;
    private String email;
    private int total_order;
    private int total_order_amount;


    // Order
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    @JsonIgnore
    private List<OrderInfo> orderInfos;

    // Card (Bank)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    @JsonIgnore
    private List<BankInfo> bankInfos;

    // Address
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    @JsonIgnore
    private List<AddressInfo> adresses;

    // Contact
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contactInfo_id", referencedColumnName = "id")
    private ContactInfo contactInfo;

    // searching engine

}

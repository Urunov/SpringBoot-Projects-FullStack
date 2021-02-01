package com.urunov.entity.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.entity.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

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
public class OrderInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String timestamp;

    private String deliveryStatus;

    private String trackPackageLink;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressInfo addressInfo;


    @ManyToOne
    @JsonIgnore
    private ProductInfo productInfo;

    @ManyToOne
    @JsonIgnore
    private Customer customer;
}

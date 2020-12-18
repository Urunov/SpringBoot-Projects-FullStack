package com.urunov.entity.elements.info;

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

    private int customerId;

    private String timestamp;

    private String deliveryStatus;

    private String trackPackageLink;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressInfo addressInfo;
}

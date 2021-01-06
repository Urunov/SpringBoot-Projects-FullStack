package com.urunov.entity.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    // card (Bank)

    // address

    // contact

    // searching engine

}

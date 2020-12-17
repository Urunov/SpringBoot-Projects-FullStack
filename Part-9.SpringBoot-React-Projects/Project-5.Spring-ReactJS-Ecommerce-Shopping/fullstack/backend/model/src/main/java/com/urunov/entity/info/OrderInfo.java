package com.urunov.entity.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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


}

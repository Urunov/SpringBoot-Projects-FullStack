package com.urunov.entity.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
@Table(indexes = {@Index(columnList = "gender_id, apparel_id, brand_id, price")})
public class ProductInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Date publicationDate;

    private double price;

    private int availableQuantity;

    private int deliveryTime;

    private float ratings;

    private boolean verificationStatus;

    private String imageLocalPath;

    private String imageUrl;



}

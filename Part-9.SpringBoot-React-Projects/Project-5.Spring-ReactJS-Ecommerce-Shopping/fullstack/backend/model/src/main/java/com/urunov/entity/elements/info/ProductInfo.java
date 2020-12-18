package com.urunov.entity.elements.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.entity.elements.categories.ApparelCategory;
import com.urunov.entity.elements.categories.GenderCategory;
import com.urunov.entity.elements.categories.PriceRangeCategory;
import com.urunov.entity.elements.categories.ProductBrandCategory;
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
//@Table(indexes = {@Index(columnList = "gender_id, apparel_id, brand_id, price")})
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

    /***
     *   Mapping and DB integration.
     *   Apparel Category
     * **/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apparel_id")
    private ApparelCategory apparelCategory;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private ProductBrandCategory productBrandCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    @JsonIgnore
    private GenderCategory genderCategory;

}

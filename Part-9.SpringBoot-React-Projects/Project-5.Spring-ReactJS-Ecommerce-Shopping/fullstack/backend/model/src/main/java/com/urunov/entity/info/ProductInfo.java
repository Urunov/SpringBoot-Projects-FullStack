package com.urunov.entity.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.entity.categories.ApparelCategory;
import com.urunov.entity.categories.GenderCategory;
import com.urunov.entity.categories.PriceRangeCategory;
import com.urunov.entity.categories.ProductBrandCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
@Component
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private ProductBrandCategory productBrandCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    @JsonIgnore
    private GenderCategory genderCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    @JsonIgnore
    private PriceRangeCategory priceRangeCategory;

    @OneToMany(mappedBy = "productInfo")
    @JsonIgnore
    private List<OrderInfo> orderInfo;

//
    public ProductInfo(int id, String productName, Date generateRandomDate, ProductBrandCategory productBrandCategory,
                       GenderCategory genderCategory, ApparelCategory apparelCategory,
                       PriceRangeCategory priceRangeCategory, int availableQuantity, int deliveryTime,
                       double price, float generateRandomFloat, boolean verificationStatus,
                       String imageLocalPath, String imageURL) {

        this.id = id;
        this.name = productName;
        this.publicationDate = generateRandomDate;
        this.productBrandCategory = productBrandCategory;
        this.genderCategory = genderCategory;
        this.apparelCategory = apparelCategory;
        this.priceRangeCategory = priceRangeCategory;
        this.availableQuantity = availableQuantity;
        this.imageUrl = imageURL;
        this.imageLocalPath = imageLocalPath;
        this.ratings = generateRandomFloat;
        this.verificationStatus = verificationStatus;
        this.deliveryTime = deliveryTime;
        this.price = price;

    }
}

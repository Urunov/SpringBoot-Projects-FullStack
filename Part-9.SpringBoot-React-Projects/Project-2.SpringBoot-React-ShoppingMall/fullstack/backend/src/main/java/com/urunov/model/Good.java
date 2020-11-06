package com.urunov.model;

import com.urunov.model.retailer.Retailer;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Good{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String internalCode;
    private String name;
    private BigDecimal currentPrice;

    @Transient
    private String imageUrl;

    @Transient
    private Boolean isAddToBucket;

    @Transient
    private byte[] image;


    @Lob
    @Column
    private String description;

    private Retailer retialer;

    private Boolean isOutdated = false;


}

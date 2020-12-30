package com.urunov.entity.elements.categories;

import lombok.*;

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
@AllArgsConstructor
@ToString
@Entity
public class ProductBrandCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

//    @OneToMany(mappedBy = "productBrandCategory", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<ProductInfo> productInfos;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "productBrandCategory")
//    @JsonIgnore
//    private List<BrandImages> brandImages;
//
    public ProductBrandCategory(String type) {
        this.type = type;
    }
}

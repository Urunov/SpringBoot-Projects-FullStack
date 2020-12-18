package com.urunov.entity.elements.categories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.entity.elements.images.BrandImages;
import com.urunov.entity.elements.info.ProductInfo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @OneToMany(mappedBy = "productBrandCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ProductInfo> productInfos;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "productBrandCategory")
    @JsonIgnore
    private List<BrandImages> brandImages;
}

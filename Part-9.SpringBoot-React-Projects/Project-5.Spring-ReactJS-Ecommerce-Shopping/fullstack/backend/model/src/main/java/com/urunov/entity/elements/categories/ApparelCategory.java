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
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ApparelCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

//    @OneToMany(mappedBy = "apparelCategory", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
//    private List<ProductInfo> productInfos;
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "apparelCategory")
//    @JsonIgnore
//    private List<ApparelImages> apparelImages;

    public ApparelCategory(String apparel) {
        this.type = apparel;
    }
}

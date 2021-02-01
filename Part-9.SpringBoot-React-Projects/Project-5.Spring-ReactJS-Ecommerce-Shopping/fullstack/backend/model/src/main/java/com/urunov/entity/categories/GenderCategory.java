package com.urunov.entity.categories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.entity.images.ApparelImages;
import com.urunov.entity.info.ProductInfo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class GenderCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    @OneToMany(mappedBy = "genderCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ApparelImages> apparelImages;
//
    @OneToMany(mappedBy = "genderCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ProductInfo> productInfos;
//
    public GenderCategory(int genderId, String gender) {

        this.id = genderId;
        this.type = gender;
    }
}

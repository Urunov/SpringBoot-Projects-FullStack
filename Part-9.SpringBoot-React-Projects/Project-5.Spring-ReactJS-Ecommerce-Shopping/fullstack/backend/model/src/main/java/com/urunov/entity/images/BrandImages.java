package com.urunov.entity.images;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.entity.categories.ProductBrandCategory;
import lombok.*;

import javax.persistence.*;
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
@Entity
public class BrandImages implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String imageLocalPath;

    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @JsonIgnore
    private ProductBrandCategory productBrandCategory;

    public BrandImages(String title, String imageLocalPath, String imageURL) {
        this.title = title;
        this.imageLocalPath = imageLocalPath;
        this.imageUrl = imageURL;
    }
}

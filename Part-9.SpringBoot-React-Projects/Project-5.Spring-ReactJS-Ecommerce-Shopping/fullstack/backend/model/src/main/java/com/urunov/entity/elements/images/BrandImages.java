package com.urunov.entity.elements.images;

import com.urunov.entity.elements.categories.ProductBrandCategory;
import lombok.*;

import javax.persistence.*;

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
public class BrandImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String imageLocalPath;

    private String imageUrl;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "brand_id", referencedColumnName = "id")
//    private ProductBrandCategory productBrandCategory;

    public BrandImages(String title, String imageLocalPath, String imageURL) {
        this.title = title;
        this.imageLocalPath = imageLocalPath;
        this.imageUrl = imageURL;
    }
}

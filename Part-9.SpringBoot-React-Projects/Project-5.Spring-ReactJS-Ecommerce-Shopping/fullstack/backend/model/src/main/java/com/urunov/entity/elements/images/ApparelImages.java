package com.urunov.entity.elements.images;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.urunov.entity.elements.categories.ApparelCategory;
import com.urunov.entity.elements.categories.GenderCategory;
import lombok.*;

import javax.persistence.*;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
public class ApparelImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String imageLocalPath;

    private String imageURL;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "apparel_id", referencedColumnName = "id")
//    //@JsonIgnore
//    private ApparelCategory apparelCategory;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "gender_id")
//    //@JsonIgnore
//    private GenderCategory genderCategory;
//

    public ApparelImages(String title, String imageLocalPath, String imageURL) {
        this.title = title;
        this.imageLocalPath = imageLocalPath;
        this.imageURL = imageURL;
    }
}

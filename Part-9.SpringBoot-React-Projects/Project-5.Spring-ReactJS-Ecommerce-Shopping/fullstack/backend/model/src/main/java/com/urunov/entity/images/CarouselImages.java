package com.urunov.entity.images;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarouselImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String link;

    private String imageLocalPath;

    private String imageURL;


    public CarouselImages(String link, String imageLocalPath, String imageURL) {
        this.link = link;
        this.imageLocalPath = imageLocalPath;
        this.imageURL = imageURL;
    }
}

package com.urunov.entity.elements.images;

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
@AllArgsConstructor
@ToString
public class CarouselImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String link;

    private String imageLocalPath;

    private String imageURL;



}

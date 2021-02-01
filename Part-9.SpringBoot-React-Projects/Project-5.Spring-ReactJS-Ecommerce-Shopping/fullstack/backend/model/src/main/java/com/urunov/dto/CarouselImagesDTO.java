package com.urunov.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CarouselImagesDTO implements Serializable {

    private int id;
    private String name;
    private String title;

    private String imageLocalPath;

    private String imageURL;

}

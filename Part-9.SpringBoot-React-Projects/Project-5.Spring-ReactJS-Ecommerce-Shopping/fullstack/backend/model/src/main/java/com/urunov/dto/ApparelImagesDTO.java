package com.urunov.dto;

import java.io.Serializable;

/**
 * User: hamdamboy
 * Project: security
 * Github: @urunov
 */
public class ApparelImagesDTO implements Serializable {

    private String title;
    private String imageLocalPath;
    private String imageUrl;

    private ApparelDTO apparelDTO;

    private GenderDTO genderInfo;

}

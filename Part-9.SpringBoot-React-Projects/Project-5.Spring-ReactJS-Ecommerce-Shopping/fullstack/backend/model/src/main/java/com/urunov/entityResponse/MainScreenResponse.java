package com.urunov.model;

import com.urunov.dto.ApparelImagesDTO;
import com.urunov.dto.BrandImageDTO;
import com.urunov.dto.CarouselImagesDTO;
import com.urunov.entity.images.CarouselImages;
import lombok.*;

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
public class MainScreenResponse implements Serializable {

    private List<BrandImageDTO> brands;

    private List<ApparelImagesDTO> apparels;

    private List<CarouselImagesDTO> carouselImagesDTOS;

    public MainScreenResponse(List<BrandImageDTO> brandDTOList, List<ApparelImagesDTO> apparelDTOList, List<CarouselImages> carouseList) {
        this.brands = brandDTOList;
        this.apparels = apparelDTOList;
    }
}

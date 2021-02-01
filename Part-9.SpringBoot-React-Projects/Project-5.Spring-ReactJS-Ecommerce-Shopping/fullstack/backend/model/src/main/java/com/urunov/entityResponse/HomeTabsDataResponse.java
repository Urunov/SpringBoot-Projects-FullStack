package com.urunov.model;

import com.urunov.dto.BrandsAndApparelsDTO;
import lombok.*;

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
public class HomeTabsDataResponse implements Serializable {

    private BrandsAndApparelsDTO men;
    private BrandsAndApparelsDTO women;
    private BrandsAndApparelsDTO boys;
    private BrandsAndApparelsDTO girls;
    private BrandsAndApparelsDTO essentials;
    private BrandsAndApparelsDTO homeAndLiving;

}

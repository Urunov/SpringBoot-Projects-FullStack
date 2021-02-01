package com.urunov.model;

import com.urunov.dto.FilterAttributesWithTotalltemsDTO;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FilterAttributesResponse implements Serializable {

    private List<FilterAttributesWithTotalltemsDTO> brands;
    private List<FilterAttributesWithTotalltemsDTO> genders;
    private List<FilterAttributesWithTotalltemsDTO> apparels;

   // private List<SortByCategory> sortby;
    private List<FilterAttributesWithTotalltemsDTO> prices;
}

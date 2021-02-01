package com.urunov.model;

import com.urunov.dto.SearchSuggestionForTwoAttrDTO;

import com.urunov.entity.categories.ApparelCategory;
import com.urunov.entity.categories.GenderCategory;
import com.urunov.entity.categories.ProductBrandCategory;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class SearchSuggestionResponse implements Serializable {

    List<GenderCategory> genderKeywords;
    List<ProductBrandCategory> brandKeywords;
    List<ApparelCategory> apparelKeywords;
    List<SearchSuggestionForTwoAttrDTO> genderApparelKeywords;
    List<SearchSuggestionForTwoAttrDTO> genderBrandKeywords;
    List<SearchSuggestionForTwoAttrDTO> apparelBrandKeywords;
    List<SearchSuggestionForTwoAttrDTO> threeAttrKeywords;

    List<String> productKeywords;

}

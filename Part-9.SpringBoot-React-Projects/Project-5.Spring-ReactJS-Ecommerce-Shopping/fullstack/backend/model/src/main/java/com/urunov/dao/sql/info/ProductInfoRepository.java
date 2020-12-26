package com.urunov.dao.sql.info;

import com.urunov.dto.SearchSuggestionForThreeAttrDTO;
import com.urunov.dto.SearchSuggestionForTwoAttrDTO;
import com.urunov.entity.elements.info.ProductInfo;
import com.urunov.model.FilterAttributesResponse;
import com.urunov.model.HomeTabsDataResponse;
import org.javatuples.Pair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {

    Pair<Long, List<ProductInfo>> getProductByCategories(HashMap<String, String> conditionMap);

    List<ProductInfo> getProductsById(String[] productsIds);

    FilterAttributesResponse getFilterAttributesByProducts(HashMap<String, String> conditionMap);

    HomeTabsDataResponse getBrandsAndApparelsByGender();

    List<SearchSuggestionForThreeAttrDTO> getGenderApparelBrandByIdAndName();

    List<SearchSuggestionForTwoAttrDTO> getGenderAndApparelByIdAndName();

    List<SearchSuggestionForTwoAttrDTO> getGenderAndBrandByIdAndName();

    List<SearchSuggestionForTwoAttrDTO> getApparelAndBrandByIdAndName();

    @Query(value = "SELECT DISTICT p.name FROM ProductInfo ")
    List<String> getProductByName();

}

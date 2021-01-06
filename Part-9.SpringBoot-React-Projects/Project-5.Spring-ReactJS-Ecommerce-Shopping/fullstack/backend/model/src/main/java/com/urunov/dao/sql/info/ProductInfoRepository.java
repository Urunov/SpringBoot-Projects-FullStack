package com.urunov.dao.sql.info;

import com.urunov.entity.info.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
//@Component
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {

//    Pair<Long, List<ProductInfo>> getProductsByCategories(HashMap<String, String> conditionMap);
//
//    List<ProductInfo> getProductsById(String[] productIds);

//    FilterAttributesResponse getFilterAttributesByProducts(HashMap<String, String> conditionMap);
//
//    HomeTabsDataResponse getBrandsAndApparelsByGender();
//
//    List<SearchSuggestionForThreeAttrDTO> getGenderApparelBrandByIdAndName();
//
//    List<SearchSuggestionForTwoAttrDTO> getGenderAndApparelByIdAndName();
//
//    List<SearchSuggestionForTwoAttrDTO> getGenderAndBrandByIdAndName();
//
//    List<SearchSuggestionForTwoAttrDTO> getApparelAndBrandByIdAndName();
//
//    @Query(value = "SELECT DISTINCT p.name FROM ProductInfo p")
//    List<String> getProductByName();

}

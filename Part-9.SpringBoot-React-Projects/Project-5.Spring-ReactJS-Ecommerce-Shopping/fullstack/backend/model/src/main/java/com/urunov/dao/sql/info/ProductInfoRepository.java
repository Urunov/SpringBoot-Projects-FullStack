//package com.urunov.dao.sql.info;
//
//import com.urunov.dto.SearchSuggestionForThreeAttrDTO;
//import com.urunov.dto.SearchSuggestionForTwoAttrDTO;
//import com.urunov.entity.elements.info.ProductInfo;
//import com.urunov.model.FilterAttributesResponse;
//import com.urunov.model.HomeTabsDataResponse;
//import org.javatuples.Pair;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//
///**
// * User: hamdamboy
// * Project: model
// * Github: @urunov
// */
////@Component
//public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {
//
//    Pair<Long, List<ProductInfo>> getProductsByCategories(HashMap<String, String> conditionMap);
//
//    List<ProductInfo> getProductsById(String[] productIds);
//
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
//
//}

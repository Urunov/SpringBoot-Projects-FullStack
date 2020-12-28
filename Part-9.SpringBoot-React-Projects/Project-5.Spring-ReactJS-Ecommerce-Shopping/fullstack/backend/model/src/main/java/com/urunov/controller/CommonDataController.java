package com.urunov.controller;

import com.urunov.dto.ProductInfoDTO;
import com.urunov.entity.elements.info.ProductInfo;
import com.urunov.model.FilterAttributesResponse;
import com.urunov.model.MainScreenResponse;
import com.urunov.model.SearchSuggestionResponse;

import com.urunov.service.interfaces.CommonDataService;
import com.urunov.service.interfaces.LoadFakeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */

@RestController
public class CommonDataController {

    @Autowired
    Environment environment;

    @Autowired
    CommonDataService commonDataService;

    @Autowired
    LoadFakeDataService loadFakeDataService;

    public void fillWithTestDate(){
        if(Objects.equals(environment.getProperty("ACTIVE_PROFILE"), "dev")){
            loadFakeDataService.loadTestData();
        }
    }

    @GetMapping(value = "/products", params = "q")
    public ResponseEntity<?> getProductsByCategories(@RequestParam("q") String queryParams)
    {
        ProductInfoDTO productInfoDTO = commonDataService.getProductsByCategories(queryParams);

        if(productInfoDTO == null) {
            return ResponseEntity.badRequest().body("Query has not followed the required format.");
        }
        return ResponseEntity.ok(productInfoDTO);
    }

    @GetMapping(value = "/products", params = "product_id")
    public ResponseEntity<?> getProductsById(@RequestParam("product_id") String queryParams)
    {
        HashMap<Integer, ProductInfo> resultMap = commonDataService.getProductsById(queryParams);

        if(resultMap == null)
        {
            return ResponseEntity.badRequest().body("Query has not followed the required format.");
        }

        return ResponseEntity.ok(resultMap);
    }


    @GetMapping("/home")
    public ResponseEntity <?> getMainScreenData(){

        MainScreenResponse mainScreenInfoList = commonDataService.getHomeScreenData("homeAPI");
        if(mainScreenInfoList == null) {
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(mainScreenInfoList);
    }

    @GetMapping(value = "/filter", params = "q")
    public ResponseEntity<?> getFilterAttributesProducts(@RequestParam("g") String queryParams)
    {
        String[] splitParams = queryParams.split("=");
        if(splitParams.length>=1 && splitParams[0].equals("productname")){
            queryParams = "category=all";
        }

        FilterAttributesResponse result = commonDataService.getFilterAttributesByProducts(queryParams);

        if(result == null)
        {
            return ResponseEntity.badRequest().body("Query has not followed the required format.");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/search-suggestion-list")
    public ResponseEntity<?> getSearchSuggestionList() {
        SearchSuggestionResponse searchSuggestionResponse = commonDataService.getSearchSuggestionList();
        if (searchSuggestionResponse == null) {
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(searchSuggestionResponse);
    }
}

package com.urunov.controller;

import com.urunov.model.Good;
import com.urunov.payload.PagedResponse;
import com.urunov.payload.good.GoodResponseForRetailer;
import com.urunov.repository.GoodsRepository;
import com.urunov.repository.RetailerRepository;
import com.urunov.repository.UserRepository;
import com.urunov.security.CurrentUser;
import com.urunov.security.UserPrincipal;
import com.urunov.service.CataloguesService;
import com.urunov.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@RestController
@RequestMapping("/api")
public class CatalogueController {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RetailerRepository retailerRepository;

    @Autowired
    private CataloguesService cataloguesService;

    public PagedResponse<GoodResponseForRetailer> getCatalogueOfGoods(
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
            @RequestParam(defaultValue = "updatedAt") String sortBy,
            @RequestParam(defaultValue = "descend") String sortOrder)
    {
        return cataloguesService.getCatalogueOfGoods(page, size, sortBy, sortOrder);
    }

    @GetMapping("/getGoodById")
    public Good getGoodById(@RequestParam(value = "goodId"), String goodId){
        return goodsRepository.findGoodById(Long.valueOf(goodId));
    }

    public PagedResponse<GoodResponseForRetailer> getGoodsByRetailers
            (
            @CurrentUser UserPrincipal userPrincipal, @RequestParam(value = "retailersId") Long id,
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
            @RequestParam(defaultValue = "updatedAt") String sortBy,
            @RequestParam(defaultValue = "descend") String sortOrder,
            @RequestParam String filteredValue)
    {
        return cataloguesService.getGoodsByRetailers(userPrincipal, id, page, size, sortBy, sortOrder, filteredValue);
    }


}

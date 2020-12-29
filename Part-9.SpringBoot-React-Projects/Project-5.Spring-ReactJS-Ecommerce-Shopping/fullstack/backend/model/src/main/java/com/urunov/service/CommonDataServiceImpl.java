package com.urunov.service;

import com.urunov.dao.sql.categories.ApparelCategoryRepository;
import com.urunov.dao.sql.categories.GenderCategoryRepository;
import com.urunov.dao.sql.categories.ProductBrandCategoryRepository;
import com.urunov.dao.sql.categories.SortByCategoryRepository;
import com.urunov.dao.sql.images.ApparelImagesRepository;
import com.urunov.dao.sql.images.BrandImagesRepository;
import com.urunov.dao.sql.images.CarouselImagesRepository;
import com.urunov.dao.sql.info.ProductInfoRepository;
import com.urunov.dto.ApparelImagesDTO;
import com.urunov.dto.BrandImageDTO;
import com.urunov.dto.ProductInfoDTO;
import com.urunov.entity.elements.images.ApparelImages;
import com.urunov.entity.elements.images.BrandImages;
import com.urunov.entity.elements.images.CarouselImages;
import com.urunov.entity.elements.info.ProductInfo;
import com.urunov.model.FilterAttributesResponse;
import com.urunov.model.HomeTabsDataResponse;
import com.urunov.model.MainScreenResponse;
import com.urunov.model.SearchSuggestionResponse;
import com.urunov.service.interfaces.CommonDataService;
import org.javatuples.Pair;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
@Service
public class CommonDataServiceImpl implements CommonDataService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private GenderCategoryRepository genderCategoryRepository;

    @Autowired
    private ApparelCategoryRepository apparelCategoryRepository;

    @Autowired
    private ProductBrandCategoryRepository productBrandCategoryRepository;

    @Autowired
    private BrandImagesRepository brandImagesRepository;

    @Autowired
    private ApparelImagesRepository apparelImagesRepository;

    @Autowired
    private CarouselImagesRepository carouselImagesRepository;

    @Autowired
    private SortByCategoryRepository sortByCategoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    private HashMap<String, String> getConditionMapFromQuery(String queryParam) {
        // append :: at the end so that we can split even if there is just one condition
        // for eg ?q=brand=1::

        queryParam = queryParam.concat("::");
        String[] separatedConditions = queryParam.split("::");

        if (separatedConditions.length > 0) {
            HashMap<String, String> conditionMap = new HashMap<>();

            for (String condition : separatedConditions) {
                String[] categories = condition.split("=");
                if (categories.length > 1) {
                    conditionMap.put(categories[0], categories[1]);
                }
            }
            return conditionMap;
        }
        return null;
    }

    @Cacheable(key = "#apiName", value = "mainScreenResponse")
    public MainScreenResponse getHomeScreenData(String apiName) {
        List<BrandImages> brandList = brandImagesRepository.getAllData();

        Type listType = new TypeToken<List<BrandImagesRepository>>() {
        }.getType();

        List<BrandImageDTO> brandDTOList = modelMapper.map(brandList, listType);

        List<ApparelImages> apparelList = apparelImagesRepository.getAllData();
        listType = new TypeToken<List<ApparelImagesDTO>>() {
        }.getType();

        List<ApparelImagesDTO> apparelDTOList = modelMapper.map(apparelList, listType);

        List<CarouselImages> carouseList = carouselImagesRepository.getAllData();

        return new MainScreenResponse(brandDTOList, apparelDTOList, carouseList);
    }

    @Cacheable(key = "#queryParams", value = "filterAttributesResponse")
    public FilterAttributesResponse getFilterAttributesByProducts(String queryParams) {
        HashMap<String, String> conditionMap = getConditionMapFromQuery(queryParams);


        if (conditionMap != null && !conditionMap.isEmpty()) {
            FilterAttributesResponse filterAttributesResponse = productInfoRepository.getFilterAttributesByProducts(conditionMap);
            filterAttributesResponse.setSortby(sortByCategoryRepository.getAllData());
            return filterAttributesResponse;
        }

        return null;
    }

    @Cacheable(key = "#queryParams", value = "productInfoDTO")
    public ProductInfoDTO getProductsByCategories(String queryParams) {

        HashMap<String, String> conditionMap = getConditionMapFromQuery(queryParams);
        ProductInfoDTO productInfoDTO = null;

        if (conditionMap != null && !conditionMap.isEmpty()) {
            Pair<Long, List<ProductInfo>> result = productInfoRepository.getProductsByCategories(conditionMap);
            if (result != null) {
                productInfoDTO = new ProductInfoDTO(result.getValue0(), result.getValue1());

            }
        }
        return productInfoDTO;
    }

    @Cacheable(key = "#queryParams", value = "hashMap")
    public HashMap<Integer, ProductInfo> getProductsById(String queryParams) {

        String[] productIds = queryParams.split(",");
        HashMap<Integer, ProductInfo> resultMap = null;

        if (productIds.length > 0) {
            List<ProductInfo> result = productInfoRepository.getProductsById(productIds);

            if (result != null) {
                resultMap = new HashMap<>();
                for (ProductInfo info : result) {
                    resultMap.put(info.getId(), info);
                }
            }
        }
        return resultMap;
    }

    @Cacheable(key = "#apiName", value = "homeTabsDataResponse")
    public HomeTabsDataResponse getBrandsAndApparelsByGender(String apiName) {

        return productInfoRepository.getBrandsAndApparelsByGender();
    }

    public SearchSuggestionResponse getSearchSuggestionList() {
        return new SearchSuggestionResponse(genderCategoryRepository.getAllData(),
                productBrandCategoryRepository.getAllData(), apparelCategoryRepository.getAllData(),
                productInfoRepository.getGenderAndApparelByIdAndName(),
                productInfoRepository.getGenderAndBrandByIdAndName(),
                productInfoRepository.getApparelAndBrandByIdAndName(),
                productInfoRepository.getGenderAndApparelByIdAndName(),
                productInfoRepository.getProductByName());
    }
}

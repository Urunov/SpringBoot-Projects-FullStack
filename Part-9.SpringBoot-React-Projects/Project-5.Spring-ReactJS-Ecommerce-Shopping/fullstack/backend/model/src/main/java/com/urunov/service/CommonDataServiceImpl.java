package com.urunov.service;

import com.urunov.dao.sql.categories.ApparelCategoryRepository;
import com.urunov.dao.sql.categories.GenderCategoryRepository;
import com.urunov.dao.sql.categories.ProductBrandCategoryRepository;
import com.urunov.dao.sql.categories.SortByCategoryRepository;
import com.urunov.dao.sql.images.ApparelImagesRepository;
import com.urunov.dao.sql.images.BrandImagesRepository;
import com.urunov.dao.sql.images.CarouselImagesRepository;
import com.urunov.dao.sql.info.ProductInfoRepository;
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
    private GenderCategoryRepository categoryRepository;

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

    private HashMap<String, String> getConditionMapFromQuery(String queryParam)
    {
        // append :: at the end so that we can split even if there is just one condition
        // for eg ?q=brand=1::

        queryParam = queryParam.concat("::");
        String[] separatedConditions = queryParam.split("::");

        if(separatedConditions.length > 0)
        {
            HashMap<String, String> conditionMap = new HashMap<>();

            for(String condition: separatedConditions)
            {
                String[] categories = condition.split("=");
                if(categories.length > 1) {
                    conditionMap.put(categories[0], categories[1]);
                }
            }
            return conditionMap;
        }
        return null;
    }

    @Cacheable(key = "#apiName", value = "mainScreenResponse")
    public MainScreenResponse getHomeScreenData(String apiName)
    {
        List<BrandImages> brandList = brandImagesRepository.getAllDate();
        Type listType = new TypeToken<List<BrandImagesRepository>>()
        {

        }.getType();

        List<BrandImagesRepository> brandDtoList = modelMapper.map(brandList, listType);


        List<ApparelImages> apparelList = apparelImagesRepository.getAllData();
        listType = new TypeToken<List<ApparelCategoryRepository>>() {
        }.getType();

        List<ApparelImagesRepository> apparelDTOList = modelMapper.map(apparelList, listType);

        List<CarouselImages> carouselImages = carouselImagesRepository.getAllData();

        return new MainScreenResponse(brandDtoList, apparelDTOList, carouselImages);
    }




    @Override
    public MainScreenResponse getHomeScreenData(String apiName) {
        return null;
    }

    @Override
    public FilterAttributesResponse getFilterAttributesByProducts(String queryParams) {
        return null;
    }

    @Override
    public ProductInfoDTO getProductsByCategories(String queryParams) {
        return null;
    }

    @Override
    public HashMap<Integer, ProductInfo> getProductsById(String queryParams) {
        return null;
    }

    @Override
    public HomeTabsDataResponse getBrandsAndApparelsByGender(String apiName) {
        return null;
    }

    @Override
    public SearchSuggestionResponse getSearchSuggestionList() {
        return null;
    }
}

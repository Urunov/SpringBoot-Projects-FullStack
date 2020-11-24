package com.urunov.service;

import com.urunov.exception.BadRequestException;
import com.urunov.model.Good;
import com.urunov.model.Orders;
import com.urunov.model.User;
import com.urunov.model.enumdto.OrderStatus;
import com.urunov.model.retailer.Retailer;
import com.urunov.payload.PagedResponse;
import com.urunov.payload.good.GoodResponseForRetailer;
import com.urunov.repository.GoodRepository;
import com.urunov.repository.GoodsRepository;
import com.urunov.repository.RetailerRepository;
import com.urunov.repository.UserRepository;
import com.urunov.security.UserPrincipal;
import com.urunov.utils.AppConstants;
import com.urunov.utils.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Service
public class CataloguesService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RetailerRepository retailersRepository;

    @Autowired
    private StringUtils stringUtils;

    public PagedResponse<GoodResponseForRetailer> getCatalogueOfGoods(int page, int size, String sortBy, String sortOrder)
    {
        validatePageNumberAndSize(page, size);
        Pageable pageable;
        if(sortOrder.equals("ascend"))
            pageable = (Pageable) PageRequest.of(page, size, Sort.by(sortBy).ascending());
        else
            pageable = (Pageable) PageRequest.of(page, size, Sort.by(sortBy).descending());

        Page<Good>goodList = goodsRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        if(goodList.getNumberOfElements() == 0)
        {
            return new PagedResponse<>(Collections.emptyList(), goodList.getNumber(),
                    goodList.getSize(), goodList.getTotalElements(), goodList.getTotalPages(), goodList.isLast());
        }

        goodList.forEach(good -> {
            if(good.getImage() != null)
                good.setImageUrl(new String(Base64.decodeBase64(good.getImage()), StandardCharsets.UTF_8));
        });
        List<GoodResponseForRetailer> content = goodList.map(good -> new GoodResponseForRetailer(good)).getContent();

        return new PagedResponse<>(content, goodList.getNumber(),
                goodList.getSize(), goodList.getTotalElements(), goodList.getTotalPages(), goodList.isLast());
    }

    public PagedResponse<GoodResponseForRetailer> getGoodsByRetailers(UserPrincipal userPrincipal, Long id, int page, int size, String sortBy, String sortOrder, String filterValue)
    {
        List<String> filters = Arrays.asList(stringUtils.removeUseless(filterValue).split(" "));
        validatePageNumberAndSize(page, size);
        Pageable pageable;
        Page<Good> goodList;
        User user;
        List<Orders> ordersList;
        if(sortOrder.equals("ascend"))
            pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        else
            pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        Orders newOrder;
        if(id == 0L)
        {
            goodList = goodsRepository.findByIsOutdated(false, pageable);
            goodList.forEach(o -> o.setImageUrl("data:image/jpg;base64," + Base64.encodeBase64String(goodList.getContent().get(0).getImage())));
        }
        else
        {
            Retailer retailer = retailersRepository.findById(id).orElse(null);
            if(retailer != null && !retailer.getIsOutdated())
            {
                if(userPrincipal != null)
                {
                    goodList = filterValue.equals("0")? goodsRepository.findGoodByRetailerAndIsOutdated(retailer, false, pageable)
                            : goodRepository.findGoodByRetailerAndIsOutdatedAndNameContaining(retailer, false, pageable, filters);
                    user = userRepository.findById(userPrincipal.getId()).get();
                    ordersList = user.getOrdersList().stream().filter(orders -> orders.getStatus().equals(OrderStatus.NEW)).collect(Collectors.toList());
                    if(!ordersList.isEmpty())
                    {
                        newOrder = ordersList.get(0);
                        newOrder.getOrderDetailsList().forEach(orderDetails -> {
                            goodList.getContent().forEach(good -> {
                                if(good.equals(orderDetails.getGood()))
                                    good.setIsAddToBucket(true);
                            });
                        });
                    }
                    goodList.getContent().forEach(o -> o.setImageUrl("data:image/jpg;base64," + Base64.encodeBase64String(o.getImage())));
                }
                else
                {
                    goodList = filterValue.equals("0")? goodsRepository.findGoodByRetailerAndIsOutdated(retailer, false, pageable)
                            : goodRepository.findGoodByRetailerAndIsOutdatedAndNameContaining(retailer, false, pageable, filters);
                    goodList.getContent().forEach(o -> o.setImageUrl("data:image/jpg;base64," + Base64.encodeBase64String(o.getImage())));
                }
            }
            else
                return new PagedResponse<>(null, 0,
                        0, 0, 0, true);
        }
        List<GoodResponseForRetailer> content = goodList.map(good -> new GoodResponseForRetailer(good)).getContent();
        return new PagedResponse<>(content, goodList.getNumber(),
                goodList.getSize(), goodList.getTotalElements(), goodList.getTotalPages(), goodList.isLast());
    }

    private void validatePageNumberAndSize(int page, int size)
    {
        if(page < 0)
        {
            throw new BadRequestException("this page cannot be null or zero" +
                    "Номер страницы не может быть меньше нуля.");
        }
        if(size > AppConstants.MAX_PAGE_SIZE)
        {
            throw new BadRequestException("Размер страницы не должен превышать " + AppConstants.MAX_PAGE_SIZE);
        }
    }
    }



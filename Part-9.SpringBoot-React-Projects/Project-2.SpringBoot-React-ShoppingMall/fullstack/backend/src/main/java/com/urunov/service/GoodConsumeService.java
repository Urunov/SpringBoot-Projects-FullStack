package com.urunov.service;

import com.urunov.model.Good;
import com.urunov.model.User;
import com.urunov.model.enumdto.OrderStatus;
import com.urunov.model.retailer.Retailer;
import com.urunov.payload.good.GoodListResponse;
import com.urunov.payload.good.GoodResponse;
import com.urunov.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Service
public class GoodConsumeService {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    RetailerRepository retailerRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    public void goodProcess(GoodListResponse goodListResponse){

        for(GoodResponse goodResponse: goodListResponse.getGoodList())
        {
            Retailer retailer = retailerRepository.findByInternalCode(goodResponse.getGoodId()).orElse(null);
            if(retailer == null)
                continue;
            List<Good> existGoods = goodsRepository.findByInternalCodeAndRetailer(goodResponse.getInternalCode(), retailer);

            if(!existGoods.isEmpty()) {
                existGoods.forEach(
                        o -> {
                            o.setIsOutdated(true);
                            goodsRepository.save(o);
                        });
                removeOutdatedGoodsFromBuckets(existGoods);
            }

             if(goodResponse.getIsOutdated() !=null && !goodResponse.getIsOutdated())
             {
                 Good good = new Good(
                         goodResponse.getName(),
                         goodResponse.getPrice(),
                         goodResponse.getImage(),
                         goodResponse.getIngredients(),
                         retailerRepository.findByInternalCode(goodResponse.getRetailer()).orElse(null),
                         goodResponse.getInternalCode());

                        goodsRepository.save(good);

             }
        }
    }

    private void removeOutdatedGoodsFromBuckets(List<Good> outdatedGoods){

        for(Good good: outdatedGoods)
        {
            for(User user: userRepository.findAll())
            {
                orderRepository.findFirstByStatusAndUser(OrderStatus.NEW, user)
                        .flatMap(orders -> orderDetailsRepository.findByGoodAndOrder(good, orders))
                        .ifPresent(orderDetails -> orderDetailsRepository.delete(orderDetails));
            }
        }
    }

}


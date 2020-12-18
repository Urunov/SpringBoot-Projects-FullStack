package com.urunov.dto;

import com.urunov.entity.elements.info.ProductInfo;

import java.io.Serializable;
import java.util.List;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
public class ProductInfoDTO implements Serializable {

    private Long totalCount;
    private List<ProductInfo> products;
}

package com.urunov.dao.sql.info;

import com.urunov.entity.info.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: hamdamboy
 * Project: model
 * Github: @urunov
 */
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer> {
}

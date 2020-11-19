package com.urunov.repository;

import com.urunov.model.Good;
import com.urunov.model.OrderDetails;
import com.urunov.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    List<OrderDetails> findAllByOrder(Orders orders);

    Optional<OrderDetails> findByGoodAndOrder(Good good, Orders order);
}

package com.urunov.repository;

import com.urunov.model.Orders;
import com.urunov.model.User;
import com.urunov.model.enumdto.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
public interface OrderRepository extends JpaRepository<Orders, Long>
{
    Optional<Orders> findFirstByStatusAndUser(OrderStatus status, User user);

    List<Orders> findAllByStatusAndPaymentNumberIsNotNull(OrderStatus status);

    List<Orders> findAllByStatusAndTaxiOrderIdIsNotNull(List<OrderStatus> status);

    Page<Orders> findAllByUser(User user, Pageable pageable);

    Page<Orders> findAllByUserAndStatusIn(User user, List<OrderStatus> statusList, Pageable pageable);
}

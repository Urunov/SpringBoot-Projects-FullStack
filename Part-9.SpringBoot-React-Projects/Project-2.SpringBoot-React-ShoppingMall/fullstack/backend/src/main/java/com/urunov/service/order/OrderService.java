package com.urunov.service.order;

import com.urunov.exception.BadRequestException;
import com.urunov.kafkaService.Producer;
import com.urunov.model.Orders;
import com.urunov.model.User;
import com.urunov.model.enumdto.OrderStatus;
import com.urunov.payload.ApiResponse;
import com.urunov.payload.PagedResponse;
import com.urunov.payload.order.OrderResponse;
import com.urunov.repository.OrderRepository;
import com.urunov.repository.UserRepository;
import com.urunov.security.UserPrincipal;
import com.urunov.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * User: hamdamboy
 * Project: Shopping
 * Github: @urunov
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    Producer producer;

    public PagedResponse<OrderResponse> getAllUserOrders(int page, int size, String sortOrder, Boolean isActive, UserPrincipal userPrincipal, String ... sortBy)
    {
        validatePageNumberAndSize(page, size);
        Pageable pageable;
        Page<Orders> ordersList;

        if(sortOrder.equals("ascend"))
            pageable = (Pageable) PageRequest.of(page, size, Sort.by(
                    Sort.Order.asc(sortBy[0]),
                    Sort.Order.desc(sortBy[1])));
        else
            pageable = (Pageable) PageRequest.of(page, size, Sort.by(
                    Sort.Order.asc(sortBy[0]),
                    Sort.Order.desc(sortBy[1])));

        User user = userRepository.findById(userPrincipal.getId()).orElse(null);

        if(user == null){
            return new PagedResponse<>(Collections.emptyList(), 0, 0, 0, 0, true);
        }

        if(isActive)
            ordersList = orderRepository.findAllByUserAndStatusIn(user, Arrays.asList(OrderStatus.inProgress, OrderStatus.awaitingPayment,
                    OrderStatus.paid, OrderStatus.deliveryInProgress, OrderStatus.courierFound, OrderStatus.courierSearch, OrderStatus.awaitingConfirmation), pageable);
        else
            ordersList = orderRepository.findAllByUserAndStatusIn(user, Arrays.asList(OrderStatus.delivered, OrderStatus.canceled), pageable);

        if(ordersList.getNumberOfElements() == 0)
        {
            return new PagedResponse<>(Collections.emptyList(), ordersList.getNumber(),
                    ordersList.getSize(), ordersList.getTotalElements(), ordersList.getTotalPages(), ordersList.isLast());
        }

        List<OrderResponse> responseList = ordersList.map(orders -> new OrderResponse(orders)).getContent();
        return new PagedResponse<>(responseList, ordersList.getNumber(),
                ordersList.getSize(), ordersList.getTotalElements(), ordersList.getTotalPages(), ordersList.isLast());
    }


    public ResponseEntity<?> statusDelivered(UserPrincipal userPrincipal, OrderResponse orderResponse)
    {
        Orders orders = orderRepository.findById(orderResponse.getId()).orElse(null);
        User user = userRepository.findById(userPrincipal.getId()).orElse(null);

        if(user !=null &&  orders !=null && user.equals(orders.getUser())){
            switch (orderResponse.getStatus()){
                case "AwaitingPayment/Ожидает оплаты":
                    orders.setStatus(OrderStatus.awaitingPayment);
                    break;
                case "New/Новый"  :
                    orders.setStatus(OrderStatus.NEW);
                    break;
                case "InProgress/В обработке":
                    orders.setStatus(OrderStatus.inProgress);
                    break;
                case "Paid/Оплачен":
                    orders.setStatus(OrderStatus.paid);
                    break;
                case "Canceled/Отменен":
                    orders.setStatus(OrderStatus.canceled);
                    break;
                case "CourierSearch/Поиск курьера":
                    orders.setStatus(OrderStatus.courierSearch);
                    break;
                case "FoundCourier/Курьер найден":
                    orders.setStatus(OrderStatus.courierFound);
                    break;
                case "DeliveryInProgress/Выполняется доставка":
                    orders.setStatus(OrderStatus.deliveryInProgress);
                    break;
                case "AwaitingConfirmation/Ожидает подтверждения":
                    orders.setStatus(OrderStatus.awaitingConfirmation);
                    break;
                case "Delivered/Доставлен":
                    orders.setStatus(OrderStatus.delivered);
                    break;
            }
         orderRepository.save(orders);
            producer.sendOrderRequest(orders);
            return new ResponseEntity(new ApiResponse(true, "Status updated sucessfully/ Статус заказа успешно изменен!", new Date(), orderResponse), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(new ApiResponse(true, "Error updating process of the status/ При изменении статуса заказа произошла ошибка.", new Date(), orderResponse), HttpStatus.BAD_REQUEST);
        }
    }


    private void validatePageNumberAndSize(int page, int size){

        if(page< 0) {
            throw new BadRequestException("Number of page cannot be 0. / Номер страницы не может быть меньше нуля.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE){
            throw new BadRequestException("Size of page cannot suitable/ Размер страницы не должен превышать" + AppConstants.MAX_PAGE_SIZE);
        }
    }
}

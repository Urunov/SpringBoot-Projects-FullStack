//package com.urunov.controller;
//
//import com.urunov.payload.order.OrderResponse;
//import com.urunov.repository.GoodsRepository;
//import com.urunov.repository.OrderDetailsRepository;
//import com.urunov.repository.OrderRepository;
//import com.urunov.repository.UserRepository;
//import com.urunov.security.CurrentUser;
//import com.urunov.security.UserPrincipal;
//import com.urunov.service.taxiMaster.TaxiOrderProcess;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import com.urunov.utils.AppConstants;
///**
// * Created by:
// * User: hamdamboy
// * Project: IntelliJ IDEA
// * Github: @urunov
// */
//
//@RestController
//@RequestMapping("/api")
//public class OrderController {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private OrderDetailsRepository orderDetailsRepository;
//
//    @Autowired
//    private TaxiOrderProcess taxiOrderProcess;
//
//    @Autowired
//    private KafkaProperties.Producer producer;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private GoodsRepository goodsRepository;
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @GetMapping("/order/getAllUserOrders")
//    public PagedResponse<OrderResponse> getAllUserOrders(
//            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
//            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
//            @RequestParam(defaultValue = "createdAt") String sortBy,
//            @RequestParam(defaultValue ="descend") String sortOrder,
//            @RequestParam(value = "isActive", defaultValue = "true") Boolean isActive,
//            @CurrentUser UserPrincipal userPrincipal)
//    {
//        return orderService.getAllUserOrders(page, size, sortOrder, isActive, userPrincipal, "status", sortBy);
//    }
//
//
//}

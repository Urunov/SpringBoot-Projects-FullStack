package spring.mvc.service.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc.orders.entities.Order;
import spring.mvc.orders.repository.OrderRepository;
import spring.mvc.security.entity.User;
import spring.mvc.security.repository.UserRepository;

import java.util.List;

/**
 * @Created 08 / 04 / 2020 - 5:47 PM
 * @project SpringMultipleDataStructure
 * @Author Hamdamboy
 */
@Service
public class UserOrdersService {
    //
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(transactionManager = "securityTransactionManager")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Transactional(transactionManager = "ordersTransactionManager")
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

}

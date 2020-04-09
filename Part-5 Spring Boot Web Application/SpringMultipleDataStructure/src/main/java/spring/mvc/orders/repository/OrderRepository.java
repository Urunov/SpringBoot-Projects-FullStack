package spring.mvc.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.mvc.orders.entities.Order;

/**
 * @Created 09 / 04 / 2020 - 9:12 AM
 * @project SpringMultipleDataStructure
 * @Author Hamdamboy
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}

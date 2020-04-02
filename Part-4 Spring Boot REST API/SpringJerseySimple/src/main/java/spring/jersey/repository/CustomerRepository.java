package spring.jersey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.jersey.domain.Customer;

import java.util.List;

/**
 * @Created 02 / 04 / 2020 - 3:29 PM
 * @project SpringJerseySimple
 * @Author Hamdamboy
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}

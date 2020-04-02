package spring.jersey.service;

import spring.jersey.domain.Customer;

import java.util.List;

/**
 * @Created 02 / 04 / 2020 - 3:33 PM
 * @project SpringJerseySimple
 * @Author Hamdamboy
 */
public interface CustomerService {
    //
    List<Customer> findAll();
   // Customer findOne(Long id);
    Customer save(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
    List<Customer> findByFirstAndLastName(String fname, String lname);
}

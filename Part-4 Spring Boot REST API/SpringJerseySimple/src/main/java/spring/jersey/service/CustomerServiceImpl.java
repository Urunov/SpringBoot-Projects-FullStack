package spring.jersey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.jersey.domain.Customer;
import spring.jersey.repository.CustomerRepository;

import java.util.List;

/**
 * @Created 02 / 04 / 2020 - 3:33 PM
 * @project SpringJerseySimple
 * @Author Hamdamboy
        */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    //

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

//    @Override
//    public Customer findOne(Long id) {
//       return customerRepository.findOne(id);
//    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> findByFirstAndLastName(String fname, String lname) {
        return customerRepository.findByFirstNameAndLastName(fname, lname);
    }
    //

}

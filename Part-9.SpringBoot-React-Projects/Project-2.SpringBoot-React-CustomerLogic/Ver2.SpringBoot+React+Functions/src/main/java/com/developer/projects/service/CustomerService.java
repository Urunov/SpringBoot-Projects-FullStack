package com.developer.projects.service;

import com.developer.projects.model.Customer;
import com.developer.projects.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

/**
 * @Author: apple
 * @created on 13/07/2020
 * @Project is SpringBootReactCustomer
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAlCustomer(){
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Boolean exitById(Integer id){
        return customerRepository.existsById(id);
    }

    public Optional<Customer> getCustomerById(Integer id){
        return customerRepository.findById(id);
    }

    public Optional<Customer> updateCustomer(Integer id, Customer customer){
        return customerRepository.findById(id).map((d)-> {
            d.setName(customer.getName());
            d.setDob(customer.getDob());
            d.setCriditlimit(customer.getCriditlimit());

            return customerRepository.save(d);
        });
    }

    public void deleteId(Integer id) {
        customerRepository.deleteById(id);
    }
}

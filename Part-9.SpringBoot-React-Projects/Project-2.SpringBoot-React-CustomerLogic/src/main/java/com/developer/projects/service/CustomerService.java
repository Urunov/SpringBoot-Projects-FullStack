package com.developer.projects.service;

import com.developer.projects.model.Customer;
import com.developer.projects.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

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

}

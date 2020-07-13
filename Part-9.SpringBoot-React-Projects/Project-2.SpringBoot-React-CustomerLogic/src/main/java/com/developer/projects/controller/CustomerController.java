package com.developer.projects.controller;

import com.developer.projects.model.Customer;
import com.developer.projects.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: apple
 * @created on 13/07/2020
 * @Project is SpringBootReactCustomer
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String showData(){
        return "test";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return customerService.getAlCustomer();
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer add(@Valid @RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

}

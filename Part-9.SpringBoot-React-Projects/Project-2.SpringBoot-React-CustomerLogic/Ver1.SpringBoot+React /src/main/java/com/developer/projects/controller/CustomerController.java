package com.developer.projects.controller;

import com.developer.projects.model.Customer;
import com.developer.projects.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @Author: apple
 * @created on 13/07/2020
 * @Project is SpringBootReactCustomer
 */
@RestController
@CrossOrigin("http://localhost:3000")
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

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Optional<Customer> getCustomerById(@PathVariable("id") String id){
        return customerService.getCustomerById(Integer.parseInt(id));
    }
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer add(@Valid @RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public Optional<Customer> update(@PathVariable("id") String id, @Valid @RequestBody Customer customer){
        return customerService.updateCustomer(Integer.parseInt(id), customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") String id){
         customerService.deleteId(Integer.parseInt(id));

      return ResponseEntity.ok().body("Customer " + id   + " has been removed");
    }
}

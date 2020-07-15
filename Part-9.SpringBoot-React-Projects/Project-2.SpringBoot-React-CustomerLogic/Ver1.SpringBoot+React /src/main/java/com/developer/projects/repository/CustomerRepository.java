package com.developer.projects.repository;

import com.developer.projects.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: apple
 * @created on 13/07/2020
 * @Project is SpringBootReactCustomer
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

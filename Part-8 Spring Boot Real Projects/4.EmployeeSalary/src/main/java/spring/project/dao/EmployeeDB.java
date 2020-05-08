package spring.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.project.model.Employee;

/**
 * @Author: apple
 * @created on 02/05/2020
 * @Project is EmployeeSalary
 */

public interface EmployeeDB extends JpaRepository<Employee, Long> {

}

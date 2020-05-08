package spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.project.dao.EmployeeDB;
import spring.project.model.Employee;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: apple
 * @created on 02/05/2020
 * @Project is EmployeeSalary
 */

@Service
@Transactional
public class EmployeeService {
    //
    @Autowired
    private EmployeeDB employeeDB;

    public List<Employee> listAll() {
        return employeeDB.findAll();
    }

    public void save(Employee employee) {
        employeeDB.save(employee);
    }

    public Employee get(long id) {
        return employeeDB.findById(id).get();
    }

    public void delete(long id) {
        employeeDB.deleteById(id);
    }
}

package spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.model.Employee;

/**
 * @Created 25 / 03 / 2020 - 5:24 PM
 * @project SpringRestAPI
 * @Author Hamdamboy
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

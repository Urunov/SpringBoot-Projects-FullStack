package spring.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.swagger.model.Employee;

/**
 * @Created 03 / 04 / 2020 - 10:48 AM
 * @project SpringSwagger
 * @Author Hamdamboy
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

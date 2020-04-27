package spring.unittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.unittest.model.Employee;

/**
 * @Created 27 / 04 / 2020 - 4:13 PM
 * @project 1.SpringUnitTest
 * @Author Hamdamboy
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

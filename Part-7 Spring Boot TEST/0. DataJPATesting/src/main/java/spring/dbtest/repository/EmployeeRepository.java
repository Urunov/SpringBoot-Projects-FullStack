package spring.dbtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.dbtest.model.Employee;

/**
 * @Created 27 / 04 / 2020 - 2:03 PM
 * @project JPATesting
 * @Author Hamdamboy
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByFirstName(String username);
}


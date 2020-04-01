package spring.restdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.restdb.model.Employee;

/**
 * @Created 01 / 04 / 2020 - 5:19 PM
 * @project SpringRestDB
 * @Author Hamdamboy
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

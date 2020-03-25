package spring.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.aop.model.Employee;

/**
 * @Created 25 / 03 / 2020 - 9:25 AM
 * @project SpringAspectOrinentProgram
 * @Author Hamdamboy
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

package spring.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import spring.project.configure.Employee;

import java.util.List;

/**
 * @Created 04 / 05 / 2020 - 5:27 PM
 * @project EmployeeSearch
 * @Author Hamdamboy
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(value = "SELECT c FROM Employee c WHERE c.name LIKE '%'||:keyword || '%'"
            + " OR c.email LIKE '%' || :keyword || '%'"
            + " OR c.address LIKE '%' || :keyword || '%'")
    public List<Employee> search(@Param("keyword") String keyword);
}

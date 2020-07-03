package pagination.sort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pagination.sort.model.Employee;

/**
 * @Author: apple
 * @created on 03/07/2020
 * @Project is PaginationSort
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

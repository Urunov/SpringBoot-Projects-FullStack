package pagination.sort.service;

import org.springframework.data.domain.Page;
import pagination.sort.model.Employee;

import java.util.List;

/**
 * @Autor: apple
 * @created on 03/07/2020
 * @Project is PaginationSort
 */
public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

    Page<Employee> findPaginated(int pageNo, int PageSize, String sortField, String sortDirection);
}

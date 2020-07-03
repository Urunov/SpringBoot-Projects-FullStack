package pagination.sort.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pagination.sort.model.Employee;
import pagination.sort.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Author: apple
 * @created on 03/07/2020
 * @Project is PaginationSort
 */

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if( optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id: " + id);
        }

        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }


    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo-1, pageSize);

        return this.employeeRepository.findAll(pageable);
    }
}

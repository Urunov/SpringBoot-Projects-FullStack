package spring.restdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.restdb.exception.ResourceNotFoundException;
import spring.restdb.model.Employee;
import spring.restdb.repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Created 01 / 04 / 2020 - 5:17 PM
 * @project SpringRestDB
 * @Author Hamdamboy
 */

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    //
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/emp")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException{
       Employee employee = employeeRepository.findById(employeeId)
               .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id: " + employeeId));
       return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/emp")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @PostMapping("/emp")
    public ResponseEntity<Employee> updateEmployee(@PathVariable (value="id") Long empId, @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id::" + empId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updateEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/emp/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id::" + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

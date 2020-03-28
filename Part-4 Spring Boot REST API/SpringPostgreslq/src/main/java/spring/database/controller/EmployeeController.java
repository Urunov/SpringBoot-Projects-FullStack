package spring.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.database.exception.ResourceNotFoundException;
import spring.database.model.Employee;
import spring.database.repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: apple
 * @created on 28/03/2020
 * @Project is SpringPosgreslq
 */

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    //
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not found for this id:: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found this id::" + employeeId));
        employee.setEmail(employeeDetails.getEmail());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
        throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for the id::" + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

package spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.exception.ResourceNotFoundException;
import spring.boot.model.Employee;
import spring.boot.repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Created 25 / 03 / 2020 - 5:21 PM
 * @project SpringRestAPI
 * @Author Hamdamboy
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    //
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String Hello(){
        return "hello";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id::"  + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empoyeedId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(empoyeedId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id::" + empoyeedId));
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updateEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws Exception {
        Employee employee = employeeRepository.findById(employeeId)
<<<<<<< HEAD
                .orElseThrow(()-> new Exception("Employee not found far this id::" + employeeId));

=======
                .orElseThrow(()-> new ResourceRequestDeniedException("Employee not found far this id::" + employeeId));
>>>>>>> d024907e51bbd955061e0a5df06d674c742efff8
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

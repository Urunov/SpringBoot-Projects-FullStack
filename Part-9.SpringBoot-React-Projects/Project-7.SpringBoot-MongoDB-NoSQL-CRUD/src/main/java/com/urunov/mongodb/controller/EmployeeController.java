package com.urunov.mongodb.controller;

import com.urunov.mongodb.exception.ResourceNotFoundException;
import com.urunov.mongodb.model.Employees;
import com.urunov.mongodb.repository.MongoDB;
import com.urunov.mongodb.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private MongoDB mongoDB;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/all")
    public List<Employees> getAllEmployee(){
        return mongoDB.findAll();
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity <Employees> getEmployeeById(@PathVariable(value = "id") String employeeId) throws ResourceNotFoundException{
        Employees employees = mongoDB.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + employeeId));
        return ResponseEntity.ok().body(employees);
    }

    @PostMapping("/employees")
    public Employees createEmployees(@Valid @RequestBody Employees employees) {
        //
        employees.setId(sequenceGeneratorService.generateSequence(Employees.SEQUENCE_NAME));
        return mongoDB.save(employees);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity <Employees> updateEmployee(@PathVariable(value = "id") String employeeId, @Valid @RequestBody Employees details) throws ResourceNotFoundException {
        //
       Employees employees = mongoDB.findById(employeeId)
               .orElseThrow(() -> new ResourceNotFoundException("Employee not found this id::" + employeeId));

       employees.setName(details.getName());
       employees.setPhone(details.getPhone());
       employees.setAge(details.getAge());
       employees.setPosition(details.getPosition());
       final Employees updatedEmployee = mongoDB.save(employees);
       return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
       //
       Employees employees = mongoDB.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + id));

       mongoDB.delete(employees);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);

       return response;
    }
}

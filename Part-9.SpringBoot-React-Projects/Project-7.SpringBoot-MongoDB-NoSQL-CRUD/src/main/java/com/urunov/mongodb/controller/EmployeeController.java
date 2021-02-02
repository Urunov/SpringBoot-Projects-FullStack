package com.urunov.mongodb.controller;

import com.urunov.mongodb.model.Employees;
import com.urunov.mongodb.repository.MongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private MongoDB mongoDB;

    @GetMapping("/")
    public List<Employees> getAllEmployee(){
        return mongoDB.findAll();
    }

}

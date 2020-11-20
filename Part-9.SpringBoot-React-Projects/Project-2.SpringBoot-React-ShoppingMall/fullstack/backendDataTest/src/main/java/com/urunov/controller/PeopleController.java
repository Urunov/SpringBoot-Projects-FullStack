package com.urunov.controller;

import com.urunov.model.People;
import com.urunov.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:8080")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    //get all employees
    @GetMapping("/people")
    public List<People> getAllEmployees(){
        return peopleRepository.findAll();
    }

    // create employee rest api
    @PostMapping("/add")
    public People createEmployee(@RequestBody People people){
        return peopleRepository.save(people);
    }


}

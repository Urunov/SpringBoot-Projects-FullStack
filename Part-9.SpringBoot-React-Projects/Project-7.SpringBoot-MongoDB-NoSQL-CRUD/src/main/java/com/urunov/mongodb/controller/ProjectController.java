package com.urunov.mongodb.controller;

import com.urunov.mongodb.model.Employees;
import com.urunov.mongodb.repository.ProjectsDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired
    private ProjectsDB projectsDB;

    @GetMapping("/project")
    public List<ProjectsDB> getAllProjects(){
        return projectsDB.findAll();
    }

}

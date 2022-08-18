package uz.bepro.springcsrftoken.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.bepro.springcsrftoken.model.Student;

import java.util.Arrays;
import java.util.List;

/**
 * @project: secure-start
 * @Date: 12.08.2022
 * @author: H_Urunov
 **/
@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {
    //
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Lary Gaga"),
            new Student(3, "Faktor2"),
            new Student(4, "Anna "),
            new Student(5, "Anna German ")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents(){
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable() Integer studentId){
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }
    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        System.out.println("Update student INFO.");
        System.out.println(String.format("%s %s", studentId, student));
    }
}
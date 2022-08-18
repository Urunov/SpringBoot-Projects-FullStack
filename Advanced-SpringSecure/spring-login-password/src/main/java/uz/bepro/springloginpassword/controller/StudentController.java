package uz.bepro.springloginpassword.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bepro.springloginpassword.model.Student;

import java.util.Arrays;
import java.util.List;

/**
 * @project: secure-start
 * @Date: 12.08.2022
 * @author: H_Urunov
 **/
@RestController
@RequestMapping("/api/v1/student/")
public class StudentController {
    //
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Lary Gaga"),
            new Student(3, "Faktor2"),
            new Student(4, "Anna ")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {

        return STUDENTS
                .stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student" + studentId));
    }
}
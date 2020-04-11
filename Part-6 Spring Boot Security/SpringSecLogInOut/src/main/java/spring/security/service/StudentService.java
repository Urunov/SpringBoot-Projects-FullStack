package spring.security.service;

import org.springframework.stereotype.Service;
import spring.security.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: apple
 * @created on 11/04/2020
 * @Project is security
 *
 */

@Service
public class StudentService {

    List<Student> list= new ArrayList<>();
    {
        list.add(new Student(1, "Hamdambouy"));
        list.add(new Student(2, "Onajon"));
        list.add(new Student(3, "Babam"));
    }

    public List<Student> getStudents(){
        return list;
    }
}

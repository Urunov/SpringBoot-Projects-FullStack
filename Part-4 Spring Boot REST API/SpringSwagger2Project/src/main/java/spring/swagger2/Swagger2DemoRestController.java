package spring.swagger2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: apple
 * @created on 05/04/2020
 * @Project is SpringSwagger2Project
 */

@RestController
public class Swagger2DemoRestController {
    //
    List<Student> students = new ArrayList<Student>();

    {
        students.add(new Student("Hamdamboy", "V", "Uzbekistan"));
        students.add(new Student("Babam", "VI", "Uzbekistan"));
        students.add(new Student("Anajonim", "v", "Uzbekistan"));
        students.add(new Student("Azamat", "V", "Uzbekistan"));
    }

    @RequestMapping(value = "/getStudents")
    public List<Student> getStudents(){
        return students;
    }

    @RequestMapping(value = "/getStudent/{name}")
    public Student getStudent(@PathVariable(value = "name") String name) {
        return students.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    @RequestMapping(value = "/getStudentByCountry/{country}")
    public List<Student> getStudentByCountry(@PathVariable(value = "country") String country) {
        System.out.println("Searching Student in country : " + country);
        List<Student> studentsByCountry = students.stream().filter(x -> x.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
        System.out.println(studentsByCountry);
        return studentsByCountry;
    }

    @RequestMapping(value = "/getStudentByClass/{cls}")
    public List<Student> getStudentByClass(@PathVariable(value = "cls") String cls) {
        return students.stream().filter(x -> x.getCls().equalsIgnoreCase(cls)).collect(Collectors.toList());
    }
}



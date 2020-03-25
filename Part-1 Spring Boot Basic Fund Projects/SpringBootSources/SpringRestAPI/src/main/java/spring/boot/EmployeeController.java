package spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

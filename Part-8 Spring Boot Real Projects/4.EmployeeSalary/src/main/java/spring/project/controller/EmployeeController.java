package spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.project.model.Employee;
import spring.project.service.EmployeeService;

import java.util.List;

/**
 * @Author: apple
 * @created on 02/05/2020
 * @Project is EmployeeSalary
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String viewHome(Model model){
        List<Employee> employeeList = employeeService.listAll();
        model.addAttribute("employeeList", employeeList);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "new_employee";
}

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditEmployeePage(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_employee");
        Employee employee1= employeeService.get(id);
        mav.addObject("employee", employee1);

        return mav;
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteEmp(@PathVariable(name = "id") int id) {
        employeeService.delete(id);

        return "redirect:/";
    }
}
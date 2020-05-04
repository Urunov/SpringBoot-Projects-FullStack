package spring.project.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.project.service.EmployeeService;

import java.util.List;
import java.util.Map;

/**
 * @Created 04 / 05 / 2020 - 5:32 PM
 * @project EmployeeSearch
 * @Author Hamdamboy
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public ModelAndView home() {
        List<Employee> listEmployee = employeeService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listEmployee", listEmployee);

        return mav;
    }

    @RequestMapping("/new")
    public String newEmployeeForm(Map<String, Object> model) {
        Employee employee = new Employee();
        model.put("employee", employee);
        return "new_employee";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }
    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Employee customer = employeeService.get(id);
        mav.addObject("customer", customer);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        employeeService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Employee> result = employeeService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);

        return mav;
    }

}

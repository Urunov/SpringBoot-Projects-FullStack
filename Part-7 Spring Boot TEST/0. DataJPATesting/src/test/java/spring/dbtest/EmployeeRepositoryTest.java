package spring.dbtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import spring.dbtest.model.Employee;
import spring.dbtest.repository.EmployeeRepository;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Created 27 / 04 / 2020 - 2:12 PM
 * @project JPATesting
 * @Author Hamdamboy
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;




    @Test
    public void testSaveEmployee(){
        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        Employee employee1 = employeeRepository.findByFirstName("admin");
        assertNotNull(employee);
        assertEquals(employee1.getFirstName(), employee.getFirstName());
        assertEquals(employee1.getLastName(), employee.getLastName());
    }

    @Test
    public void testGetEmployee(){

        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        Employee employee1 = employeeRepository.findByFirstName("admin");
        assertNotNull(employee);
        assertEquals(employee1.getFirstName(), employee.getFirstName());
        assertEquals(employee1.getLastName(), employee.getLastName());
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        employeeRepository.delete(employee);
    }

    @Test
    public void findAllEmployees() {
        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        assertNotNull(employeeRepository.findAll());
    }

    @Test
    public void deletByEmployeeIdTest() {
        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        Employee emp = employeeRepository.save(employee);
        employeeRepository.deleteById(emp.getId());
    }
}

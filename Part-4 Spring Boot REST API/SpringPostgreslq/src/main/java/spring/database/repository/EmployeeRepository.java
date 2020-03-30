package spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.database.model.Employee;

/**
 * @Author: apple
 * @created on 28/03/2020
 * @Project is SpringPosgreslq
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long > {
    //

}

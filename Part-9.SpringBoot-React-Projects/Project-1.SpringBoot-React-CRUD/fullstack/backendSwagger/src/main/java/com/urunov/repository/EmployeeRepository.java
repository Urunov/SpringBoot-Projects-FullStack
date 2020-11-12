package com.urunov.repository;

import com.urunov.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

package spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.mvc.domain.Company;

/**
 * @Created 27 / 03 / 2020 - 12:20 PM
        * @project SpringMVC
        * @Author Hamdamboy
        */
public interface CompanyRepository extends JpaRepository<Company, Integer> {


}

package spring.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.restapi.model.Developer;

/**
 * @Created 31 / 03 / 2020 - 2:30 PM
 * @project SpringRestAPI
 * @Author Hamdamboy
 */
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}

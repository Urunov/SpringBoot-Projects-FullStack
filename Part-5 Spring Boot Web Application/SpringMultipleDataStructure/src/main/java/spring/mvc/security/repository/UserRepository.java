package spring.mvc.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.mvc.security.entity.User;

/**
 * @Created 09 / 04 / 2020 - 8:55 AM
 * @project SpringMultipleDataStructure
 * @Author Hamdamboy
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}

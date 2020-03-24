package spring.thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.thymeleaf.domain.User;

/**
 * @Created 24 / 03 / 2020 - 3:20 PM
 * @project SpringMVCDatabase
 * @Author Hamdamboy
 */
public interface UserRopository extends JpaRepository<User, Integer> {
}

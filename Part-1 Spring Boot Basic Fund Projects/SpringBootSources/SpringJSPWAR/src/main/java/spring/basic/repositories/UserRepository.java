package spring.basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.basic.domain.User;

/**
 * @Created 24 / 03 / 2020 - 10:17 AM
 * @project SpringJSPWAR
 * @Author Hamdamboy
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}

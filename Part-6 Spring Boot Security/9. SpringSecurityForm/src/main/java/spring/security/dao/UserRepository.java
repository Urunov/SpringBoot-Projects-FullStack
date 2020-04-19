package spring.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.model.User;

/**
 * @Created 13 / 04 / 2020 - 10:22 AM
 * @project SpringSecurityForm
 * @Author Hamdamboy
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

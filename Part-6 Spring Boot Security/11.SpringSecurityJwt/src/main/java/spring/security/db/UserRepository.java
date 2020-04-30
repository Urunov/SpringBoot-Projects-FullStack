package spring.security.db;

import org.springframework.stereotype.Repository;
import spring.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @Created 24 / 04 / 2020 - 1:54 PM
 * @project SpringSecurityJWT
 * @Author Hamdamboy
 */

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

package spring.security.repisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.model.User;

/**
 * @Created 29 / 04 / 2020 - 3:51 PM
 * @project SpringRegistor
 * @Author Hamdamboy
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}

package spring.database.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.database.model.User;

/**
 * @Created 17 / 04 / 2020 - 1:48 PM
 * @project SpringSecureDB
 * @Author Hamdamboy
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername (String username);

}

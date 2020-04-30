package spring.custom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.custom.model.User;

/**
 * @Created 21 / 04 / 2020 - 11:12 AM
 * @project custom
 * @Author Hamdamboy
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

package aspera.registration.repository;

import aspera.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Created 02 / 06 / 2020 - 2:15 PM
 * @project SpringRegistration
 * @Author Hamdamboy
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}

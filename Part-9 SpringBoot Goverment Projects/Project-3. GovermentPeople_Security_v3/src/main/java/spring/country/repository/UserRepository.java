package spring.sample.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.sample.registration.model.User;

/**
 * @Created 29 / 06 / 2020 - 6:46 PM
 * @project RegistrationPerson
 * @Author Hamdamboy
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}

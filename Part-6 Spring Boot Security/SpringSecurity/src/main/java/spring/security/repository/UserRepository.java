package spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

/**
 * @Created 09 / 04 / 2020 - 2:19 PM
 * @project SpringSecurity
 * @Author Hamdamboy
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}

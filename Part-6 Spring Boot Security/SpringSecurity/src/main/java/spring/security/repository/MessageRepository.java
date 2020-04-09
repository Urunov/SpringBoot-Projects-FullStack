package spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.entities.Message;

/**
 * @Created 09 / 04 / 2020 - 2:19 PM
 * @project SpringSecurity
 * @Author Hamdamboy
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {
}

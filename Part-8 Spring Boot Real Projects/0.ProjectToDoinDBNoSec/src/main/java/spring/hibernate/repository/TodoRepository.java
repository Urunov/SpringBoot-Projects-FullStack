package spring.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hibernate.model.Todo;

import java.util.List;

/**
 * @Created 18 / 05 / 2020 - 1:57 PM
 * @project ProjectTodo
 * @Author Hamdamboy
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUserName(String user);
}

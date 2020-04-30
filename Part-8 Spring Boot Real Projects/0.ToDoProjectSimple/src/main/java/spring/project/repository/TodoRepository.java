package spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.project.model.Todo;

import java.util.List;

/**
 * @Created 28 / 04 / 2020 - 11:23 AM
 * @project SpringToDoSimple
 * @Author Hamdamboy
 */
//@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserName(String user);
}

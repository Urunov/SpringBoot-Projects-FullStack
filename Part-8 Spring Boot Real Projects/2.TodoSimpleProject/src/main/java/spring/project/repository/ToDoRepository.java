package spring.project.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import spring.project.entity.ToDo;

/**
 * @Author: apple
 * @created on 30/04/2020
 * @Project is SpringSimpleTodo
 */

@Repository
public interface ToDoRepository extends PagingAndSortingRepository<ToDo, Long> {


   // void addAttribute(String todos, Iterable<ToDo> all);
}

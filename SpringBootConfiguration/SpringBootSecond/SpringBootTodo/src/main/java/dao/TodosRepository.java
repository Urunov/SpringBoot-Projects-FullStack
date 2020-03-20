package dao;

import model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodosRepository extends CrudRepository<Todo, Integer>  {
}

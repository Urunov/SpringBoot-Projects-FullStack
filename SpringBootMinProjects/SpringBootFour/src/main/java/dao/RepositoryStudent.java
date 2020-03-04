package dao;

import model.Book;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryStudent extends CrudRepository <Book, Long> {

}

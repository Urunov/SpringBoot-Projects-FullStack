package repository;

import entity.SpringDBH2;
import org.springframework.data.repository.CrudRepository;

public interface Reposotory extends CrudRepository<SpringDBH2,Integer> {

}
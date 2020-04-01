package spring.database.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.database.model.Job;

/**
 * @Author: apple
 * @created on 01/04/2020
 * @Project is SpringJerseyJPA
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}

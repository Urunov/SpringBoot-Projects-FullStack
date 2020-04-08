package spring.mysqlhiber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.mysqlhiber.domain.Child;

/**
 * @Created 07 / 04 / 2020 - 5:52 PM
 * @project SpringMysqlhiber
 * @Author Hamdamboy
 */
@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
}

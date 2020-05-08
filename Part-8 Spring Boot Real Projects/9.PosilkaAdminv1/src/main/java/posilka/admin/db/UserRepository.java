package posilka.admin.db;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import posilka.admin.model.User;

/**
 * @Created 06 / 05 / 2020 - 12:29 PM
 * @project AdminPage
 * @Author Hamdamboy
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

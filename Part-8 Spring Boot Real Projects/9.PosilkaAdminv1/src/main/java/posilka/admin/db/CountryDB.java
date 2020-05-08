package posilka.admin.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import posilka.admin.model.Country;

/**
 * @Created 07 / 05 / 2020 - 1:45 PM
 * @project AdminPage
 * @Author Hamdamboy
 */
@Repository
public interface CountryDB extends JpaRepository<Country, Long> {
}

package posilka.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import posilka.admin.db.CountryDB;
import posilka.admin.model.Country;

import java.util.List;

/**
 * @Created 07 / 05 / 2020 - 1:41 PM
 * @project AdminPage
 * @Author Hamdamboy
 */

@Service
@Transactional
public class CountryService {

    @Autowired
    private CountryDB countryDB;

    public List<Country> listAll() {
        return countryDB.findAll();
    }

    public void save(Country country) {
        countryDB.save(country);
    }

    public Country get(long id) {
        return countryDB.findById(id).get();
    }

    public void delete(long id) {
        countryDB.deleteById(id);
    }
}

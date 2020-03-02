package controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class ControllerPerson {
    //

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @RequestMapping(value = "/createTable", method = RequestMethod.GET)
    public void createTable() {

        try {

            jdbcTemplate.execute("CREATE TABLE person (" +  " id SERIAL, name VARCHAR(56), role VARCHAR(20))");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/purData", method = RequestMethod.GET)
    public void pubTable(){
        jdbcTemplate.execute("INSERT into person (id, name, role) VALUES (1, 'Hamdamboy', 'Developer')");
    }
}

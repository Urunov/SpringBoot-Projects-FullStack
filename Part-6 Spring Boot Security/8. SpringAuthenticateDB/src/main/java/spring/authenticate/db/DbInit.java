package spring.authenticate.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import spring.authenticate.model.User;


import java.util.Arrays;
import java.util.List;

/**
 * @Created 17 / 04 / 2020 - 1:49 PM
 * @project SpringSecureDB
 * @Author Hamdamboy
 */

@Service
public class DbInit implements CommandLineRunner {

    UserRepository userRepository;

    public DbInit(UserRepository userRepository1){
        this.userRepository = userRepository1;
    }
    @Override
    public void run(String... args) throws Exception {
        User hamdamboy = new User("hamdamboy", "hamdamboy123", "USER", "");
        User admin = new User("admin", "admin123", "ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User ("manager", "manager123", "MANAGER", "ACCESS_TEST1");

        List<User> users = Arrays.asList(hamdamboy, admin, manager);

        //Save to db
        this.userRepository.saveAll(users);
    }
}

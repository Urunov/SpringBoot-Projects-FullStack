package spring.authenticate.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder){

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        User hamdamboy = new User("hamdamboy", passwordEncoder.encode("hamdamboy123"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User ("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");

        List<User> users = Arrays.asList(hamdamboy, admin, manager);

        //Save to db
        this.userRepository.saveAll(users);
    }
}

package spring.custom.dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.custom.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * @Created 21 / 04 / 2020 - 11:11 AM
 * @project custom
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

        // delete all
        this.userRepository.deleteAll();

        // Create User

        User me = new User("me", passwordEncoder.encode("me123"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");

        List<User> users = Arrays.asList(me, admin, manager);

        // Save to db
        this.userRepository.saveAll(users);
    }
}

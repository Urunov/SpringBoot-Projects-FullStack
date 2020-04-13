package spring.security.dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import spring.security.model.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Arrays;
import java.util.List;

/**
 * @Created 13 / 04 / 2020 - 10:22 AM
 * @project SpringSecurityForm
 * @Author Hamdamboy
 */

@Service
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passw){
        this.userRepository = userRepository;
        this.passwordEncoder = passw;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Create User
        User dan = new User("dan", passwordEncoder.encode("dan123"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");

        List<User> users = Arrays.asList(dan, admin, manager);

        //Save to db
        this.userRepository.saveAll(users);
    }

}

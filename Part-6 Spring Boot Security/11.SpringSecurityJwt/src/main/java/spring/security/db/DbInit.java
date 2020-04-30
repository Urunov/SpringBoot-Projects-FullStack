package spring.security.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.security.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * @Created 24 / 04 / 2020 - 1:54 PM
 * @project SpringSecurityJWT
 * @Author Hamdamboy
 */

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User dan = new User("dan",passwordEncoder.encode("dan123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(dan,admin,manager);

        // Save to db
        this.userRepository.saveAll(users);
    }
}

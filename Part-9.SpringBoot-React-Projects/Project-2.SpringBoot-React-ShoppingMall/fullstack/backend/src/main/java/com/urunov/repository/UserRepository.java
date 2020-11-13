package com.urunov.repository;

import com.urunov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByPhone(String phone);

    Boolean existsByPhone(String phone);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

//    @Query("select u from User w where u.username like %:username%")
//    List<User> findUsersByUsername(@Param("username") String username);
//
//    @Query("Select u.username from User u")
//    List<String> findAllUsers();
}

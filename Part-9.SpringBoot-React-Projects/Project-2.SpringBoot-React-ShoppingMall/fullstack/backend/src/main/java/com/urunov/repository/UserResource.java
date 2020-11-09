package com.urunov.repository;

import com.urunov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

///**
// * Created by:
// * User: hamdamboy
// * Project: IntelliJ IDEA
// * Github: @urunov
// */
@Repository
public interface UserResource extends JpaRepository<User, Long> {
}
////    Optional<User> findByUsernameOrEmail(String username, String email);
////
////    Optional<User> findByUsername(String username);
////
////    Optional<User> findByPhone(String phone);
////
////    Boolean existsByPhone(String phone);
////
////    Boolean existsByUsername(String username);
////
////    Boolean existsByEmail(String email);
//
////    @Query("Select u from User u where u.username like %:username%")
////    List<User> findUsersByUsername(@Param("username") String userName);
////
////    @Query("Select u.username from User u")
////    List<String> findAllUsers();
//}

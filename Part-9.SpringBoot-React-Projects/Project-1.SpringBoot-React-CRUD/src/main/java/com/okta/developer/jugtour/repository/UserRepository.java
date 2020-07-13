package com.okta.developer.jugtour.repository;

import com.okta.developer.jugtour.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 13/07/2020
 * @Project is SpringReactCrud
 */
public interface UserRepository extends JpaRepository<User, String> {
}

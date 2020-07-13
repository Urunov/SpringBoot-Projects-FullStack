package com.okta.developer.jugtour.repository;

import com.okta.developer.jugtour.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: apple
 * @created on 13/07/2020
 * @Project is SpringReactCrud
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByName(String name);
    List<Group> findAllByUserId(String id);
}

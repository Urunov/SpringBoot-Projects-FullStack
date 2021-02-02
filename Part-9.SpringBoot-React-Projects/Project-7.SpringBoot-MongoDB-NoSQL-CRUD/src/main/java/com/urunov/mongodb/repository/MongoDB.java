package com.urunov.mongodb.repository;

import com.urunov.mongodb.model.Employees;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDB extends MongoRepository<Employees, String> {
}

/**
 *    Relational Database | MongoDB
 *    ------------------------------
 *    Database   | Database
 *    Tables    --- Collections
 *    Rows      --- Documents
 *    Columns   --- Fields
 *
 *    Office website:
 *        https://www.mongodb.com/try/download/compass
 *
 * */

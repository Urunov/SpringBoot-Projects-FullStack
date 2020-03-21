package io.develop.springMysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan("<package with entities>")
public class SpringMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMySqlApplication.class, args);
    }

}

/* There are crosity in the project"
 *  1. Hibernate cannot create table in DB
 *  2. JPARepository is not integrate DB (using POSTMAN)
 *  3. What is different between JpaRepository and CRUD (CrudRepository<Ticket, Integer>)
 *  4. When we will meet again, take you.?
 * */
package com.urunov.backend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository<Interger> extends JpaRepository<Users, Interger> {

}
    
 
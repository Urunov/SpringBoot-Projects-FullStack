package com.urunov.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    
    @Autowired
    private UsersRespository userRespository;

   @ GetMapping("/")
    private List<Users> getUsers(){
        return userRespository.findAll();
        
    }

   @GetMapping("/{id}")
   public Users getUsers(@PathVariable Integer id){
       return (Users) userRespository.findById(id).orElse(null);
   }

   @PostMapping("/")
   public Users PostUsers(@RequestBody Users users){
       return (Users) userRespository.save(users);
   }
  
   @PutMapping("/")
   public Users PutUser(@RequestBody Users users) {
       Users oldUser = (Users) userRespository.findById(users.getId()).orElse(null);
       oldUser.setName(users.getName());
       oldUser.setEmail(users.getEmail());
       oldUser.setPassword(users.getPassword());
       return (Users) userRespository.save(oldUser);
   }
   @DeleteMapping("/{id}")
   public Integer DeleteUser(@PathVariable Integer id) {
       userRespository.deleteById(id);
       return id;
   }
}

package service;

import model.User;

public interface UserService {
    //
    void save(User user);

    User findByUsername(String username);
}

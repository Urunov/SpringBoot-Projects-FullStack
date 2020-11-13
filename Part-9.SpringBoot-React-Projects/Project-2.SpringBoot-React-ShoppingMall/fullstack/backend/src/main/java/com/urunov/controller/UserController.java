package com.urunov.controller;

import com.urunov.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository;
}

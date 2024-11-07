package com.example.PassGuard.service.Interface;

import com.example.PassGuard.model.User;

import java.util.Optional;

public interface UserService_Interface {
    User registerUser(User user);

    Optional<User> findByUsername(String username);

    String loginUser(String username, String password);


}

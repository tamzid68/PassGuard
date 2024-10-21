package com.example.PassGuard.service;

import com.example.PassGuard.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserService_Interface {
    User registerUser(User user);

    Optional<User> findByUsername(String username);


}

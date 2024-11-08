package com.example.PassGuard.service.UserService;

import com.example.PassGuard.dto.SecretDto;
import com.example.PassGuard.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService_Interface {
    User registerUser(User user);

    Optional<User> findByUsername(String username);

    String loginUser(String username, String password);


    List<SecretDto> convertToDtos(User user);
}

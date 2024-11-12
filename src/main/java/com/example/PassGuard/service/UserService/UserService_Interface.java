package com.example.PassGuard.service.UserService;

import com.example.PassGuard.dto.SecretDto;
import com.example.PassGuard.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService_Interface {
    void registerUser(User user) throws Exception;

    Optional<User> findByUsername(String username);

    String loginUser(String username, String password);


    List<SecretDto> convertToDtos(User user);
}

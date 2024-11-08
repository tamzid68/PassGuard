package com.example.PassGuard.service.SecretService;

import com.example.PassGuard.dto.SecretDto;
import com.example.PassGuard.model.Secret;
import com.example.PassGuard.model.User;

public interface SecretService_interface {

    Secret addSecret(Secret secret, User user);
    void deleteSecret(Long id);
    SecretDto toSecretDTO(Secret secret);

}

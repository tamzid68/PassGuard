package com.example.PassGuard.service;

import com.example.PassGuard.model.Secret;
import com.example.PassGuard.model.User;

public interface SecretService_interface {

    Secret addSecret(Secret secret, User user);
}

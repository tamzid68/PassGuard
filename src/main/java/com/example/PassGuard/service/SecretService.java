package com.example.PassGuard.service;

import com.example.PassGuard.model.Secret;
import com.example.PassGuard.model.User;
import com.example.PassGuard.repository.SecretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jasypt.util.text.AES256TextEncryptor;

import java.util.List;

@Service
public class SecretService implements SecretService_interface {
    @Autowired
    private SecretRepository secretRepository;
    private final AES256TextEncryptor encryptor;
    /*@Autowired
    private AES256TextEncryptor encryptor;*/

    @Autowired
    public SecretService(AES256TextEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    @Override
    public Secret addSecret(Secret secret, User user) {
        secret.setUser(user);
        secret.setEncryptedPassword(encryptor.encrypt(secret.getEncryptedPassword()));
        return secretRepository.save(secret);
    }

    public List<Secret> getSecrets(User user) {

        return secretRepository.findByUserId(user.getId());
    }

    public void deleteSecret(Long id) {

        secretRepository.deleteById(id);
    }
}

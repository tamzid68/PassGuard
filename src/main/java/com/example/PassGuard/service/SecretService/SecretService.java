package com.example.PassGuard.service.SecretService;

import com.example.PassGuard.dto.SecretDto;
import com.example.PassGuard.model.Secret;
import com.example.PassGuard.model.User;
import com.example.PassGuard.repository.SecretRepository;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretService implements SecretService_interface {
    @Autowired
    private SecretRepository secretRepository;
    private final AES256TextEncryptor encryptor;


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

    @Override
    public void deleteSecret(Long id) {

        secretRepository.deleteById(id);
    }


    // This method converts Secret to SecretDTO
    @Override
    public SecretDto toSecretDTO(Secret secret) {
        return new SecretDto(
                secret.getId(),
                secret.getServiceName(),
                decryptPassword(secret.getEncryptedPassword())
        );
    }

    @Override
    public String decryptPassword(String encryptedPassword) {
        try {
            return encryptor.decrypt(encryptedPassword);
        } catch (Exception e) {
            throw new RuntimeException("Failed to decrypt password", e);
        }
    }

}

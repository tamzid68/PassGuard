package com.example.PassGuard.service;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig {
    @Bean
    public AES256TextEncryptor aes256TextEncryptor() {
        AES256TextEncryptor encryptor = new AES256TextEncryptor();
        encryptor.setPassword("encryptionKey"); // Set your encryption key
        return encryptor;
    }
}

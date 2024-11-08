package com.example.PassGuard.service.EncryptionConfig;

import EncryptionConfig_Interface;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig implements EncryptionConfig_Interface {
    @Bean
    @Override
    public AES256TextEncryptor aes256TextEncryptor() {
        AES256TextEncryptor encryptor = new AES256TextEncryptor();
        encryptor.setPassword("encryptionKey"); // Set your encryption key
        return encryptor;
    }


}

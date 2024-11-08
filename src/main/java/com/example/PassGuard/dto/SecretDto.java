package com.example.PassGuard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretDto {
    private Long id;
    private String serviceName;
    private String decryptedPassword;
}

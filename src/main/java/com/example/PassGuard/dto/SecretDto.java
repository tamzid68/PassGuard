package com.example.PassGuard.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretDto {
    private Long id;
    private String serviceName;
    private String decryptedPassword;
}

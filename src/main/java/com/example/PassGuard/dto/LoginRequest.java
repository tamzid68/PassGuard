package com.example.PassGuard.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest {
    private String username;
    private String password;
}

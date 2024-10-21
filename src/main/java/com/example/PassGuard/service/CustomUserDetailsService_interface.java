package com.example.PassGuard.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetailsService_interface {
    UserDetails loadUserByUsername(String username);
}

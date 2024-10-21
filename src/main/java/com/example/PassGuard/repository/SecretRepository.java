package com.example.PassGuard.repository;

import com.example.PassGuard.model.Secret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecretRepository extends JpaRepository<Secret, Long> {
    List<Secret> findByUserId(Long userId);
}

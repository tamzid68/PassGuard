package com.example.PassGuard.repository;

import com.example.PassGuard.model.Secret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecretRepository extends JpaRepository<Secret, Long> {
    List<Secret> findByUserId(Long userId);
}

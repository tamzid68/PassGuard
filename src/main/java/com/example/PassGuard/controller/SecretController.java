package com.example.PassGuard.controller;


import com.example.PassGuard.model.Secret;
import com.example.PassGuard.model.User;
import com.example.PassGuard.service.SecretService;
import com.example.PassGuard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secrets")
public class SecretController {

    @Autowired
    private SecretService secretService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> addSecret(@RequestBody Secret secret, @RequestParam String username) {
        User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        secretService.addSecret(secret, user);
        return ResponseEntity.ok("Secret saved successfully");
    }

    @GetMapping
    public ResponseEntity<List<Secret>> getSecrets(@RequestParam String username) {
        User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(secretService.getSecrets(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSecret(@PathVariable Long id) {
        secretService.deleteSecret(id);
        return ResponseEntity.ok("Secret deleted successfully");
    }
}
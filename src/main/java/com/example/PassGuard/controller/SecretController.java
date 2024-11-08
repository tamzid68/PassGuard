package com.example.PassGuard.controller;


import com.example.PassGuard.dto.SecretDto;
import com.example.PassGuard.model.Secret;
import com.example.PassGuard.model.User;
import com.example.PassGuard.service.SecretService.SecretService_interface;
import com.example.PassGuard.service.UserService.UserService_Interface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/secrets")
public class SecretController {

//    @Autowired
//    private SecretService secretService;
//
//    @Autowired
//    private UserService userService;

    private final SecretService_interface secretService;
    private final UserService_Interface userService;

    @PostMapping
    public ResponseEntity<?> addSecret(@RequestBody Secret secret, @RequestParam String username) {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        secretService.addSecret(secret, user);
        return ResponseEntity.ok("Secret saved successfully");
    }

    @GetMapping
    public ResponseEntity<List<SecretDto>> getSecrets(@RequestParam String username) {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

//        List<SecretDto> secretDTOs = user.getSecrets().stream()
//                .map(secretService::toSecretDTO)
//                .collect(Collectors.toList());
        List<SecretDto> secretDTOs = userService.convertToDtos(user);

        return ResponseEntity.ok(secretDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSecret(@PathVariable Long id) {
        secretService.deleteSecret(id);
        return ResponseEntity.ok("Secret deleted successfully");
    }
}
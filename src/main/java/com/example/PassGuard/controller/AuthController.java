package com.example.PassGuard.controller;

import com.example.PassGuard.model.User;
import com.example.PassGuard.security.JWTUtil;
import com.example.PassGuard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User registeredUser = userService.registerUser(user);

        return ResponseEntity.ok(registeredUser);
    }

    

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        System.out.println(username+"  "+password);
        User user = userService.loginUser(username, password);
        if (user != null) {
            return "Login successful";
        }
        return "Login failed";
    }
}

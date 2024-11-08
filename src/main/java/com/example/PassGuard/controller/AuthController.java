package com.example.PassGuard.controller;

import com.example.PassGuard.dto.LoginRequest;
import com.example.PassGuard.model.User;
import com.example.PassGuard.security.JWTUtil;
import com.example.PassGuard.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        try {
            // Authenticate using the custom login method in UserService
            String token = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
            if (token == null) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Login failed: Invalid credentials");
            }

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(403).body("Login failed: " + e.getMessage());
        }

       /* System.out.print(loginRequest.getUsername()+" "+loginRequest.getPassword());
        try {
           authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            //String token = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
            String token = jwtUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(403).body("Login failed");
        }*/
    }

}

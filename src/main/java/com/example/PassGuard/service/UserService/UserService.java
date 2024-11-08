package com.example.PassGuard.service.UserService;

import com.example.PassGuard.dto.SecretDto;
import com.example.PassGuard.model.User;
import com.example.PassGuard.repository.UserRepository;
import com.example.PassGuard.security.JWTUtil;
import com.example.PassGuard.service.SecretService.SecretService_interface;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserService_Interface {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;
    private final SecretService_interface secretService;

//    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JWTUtil jwtUtil,
                       SecretService_interface secretService
                       ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.secretService = secretService;
    }


    @Override
    public User registerUser(User user){
        System.out.println(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username){
        User user = userRepository.findByUsername(username).
                orElseThrow(()-> new RuntimeException("User Dose not Exists"));
        return userRepository.findByUsername(username);
    }

    @Override
    public String loginUser(String username, String password) {
        /*User user = userRepository.findByUsername(username).
                orElseThrow(()-> new RuntimeException("User Dose not Exists"));
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername()); // Return token to client
        }
        return null; // Login failed*/
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User Does Not Exist"));
        System.out.println(password);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername()); // Return token to client
        }
        throw new RuntimeException("Invalid username or password");
    }

    @Override
    public List<SecretDto> convertToDtos(User user){
        return user.getSecrets().stream()
                .map(secretService::toSecretDTO)
                .toList();
    }

}

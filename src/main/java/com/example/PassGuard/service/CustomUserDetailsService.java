package com.example.PassGuard.service;
import com.example.PassGuard.model.User;
import com.example.PassGuard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(@Lazy UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CustomUserDetailsService() {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>()); // Add authorities as needed
    }
}

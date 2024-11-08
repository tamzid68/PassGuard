package com.example.PassGuard.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Data
@Getter
@Setter
public class Secret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceName;
    private String encryptedPassword;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

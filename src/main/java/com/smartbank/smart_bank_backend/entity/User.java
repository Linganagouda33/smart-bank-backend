package com.smartbank.smart_bank_backend.entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name",
            nullable = false,
            length = 100)
    private String fullName;

    @Column(nullable = false,
            unique = true,
            length = 100)
    private String email;

    @Column(unique = true,
            length = 15)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    // public User() {
    // }

    // public User(Long id,
    //             String fullName,
    //             String email,
    //             String phone,
    //             String password,
    //             String status,
    //             LocalDateTime createdAt,
    //             Role role) {

    //     this.id = id;
    //     this.fullName = fullName;
    //     this.email = email;
    //     this.phone = phone;
    //     this.password = password;
    //     this.status = status;
    //     this.createdAt = createdAt;
    //     this.role = role;
    // }

}
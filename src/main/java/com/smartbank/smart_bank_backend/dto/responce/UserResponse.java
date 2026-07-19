package com.smartbank.smart_bank_backend.dto.responce;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;

    private String fullName;

    private String email;

    private String phone;

    private String role;

    public UserResponse() {
    }

    public UserResponse(Long id,
                        String fullName,
                        String email,
                        String phone,
                        String role) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    // Generate Getters and Setters
}
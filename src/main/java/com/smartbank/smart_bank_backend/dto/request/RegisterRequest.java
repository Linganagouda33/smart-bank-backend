package com.smartbank.smart_bank_backend.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank(message = "Full Name is required")
    private String fullName;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits")
    private String phone;

    @Size(min = 8,max = 20,message = "Password must be between 8 and 20 characters")
    private String password;

    // Constructors

    public RegisterRequest() {
    }

    // Getters & Setters
}
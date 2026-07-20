package com.smartbank.smart_bank_backend.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartbank.smart_bank_backend.entity.Role;
import com.smartbank.smart_bank_backend.repository.RoleRepository;
import com.smartbank.smart_bank_backend.repository.UserRepository;
import com.smartbank.smart_bank_backend.service.AuthService;

@Service
public class AuthServiceImpl  implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
@Override
public ApiResponse register(RegisterRequest request) {

    if(userRepository.existsByEmail(request.getEmail())){

        throw new RuntimeException("Email already exists");
    }

    if(userRepository.existsByPhone(request.getPhone())){

        throw new RuntimeException("Phone number already exists");
    }

    Role role = roleRepository
            .findByRoleName("CUSTOMER")
            .orElseThrow(() ->
                    new RuntimeException("Role not found"));

    User user = new User();

    user.setFullName(request.getFullName());

    user.setEmail(request.getEmail());

    user.setPhone(request.getPhone());

    user.setPassword(
            passwordEncoder.encode(request.getPassword())
    );

    user.setStatus("ACTIVE");

    user.setCreatedAt(LocalDateTime.now());

    user.setRole(role);

    userRepository.save(user);

    return new ApiResponse(
            true,
            "Registration Successful"
    );
}    
}

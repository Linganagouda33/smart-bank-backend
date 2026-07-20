package com.smartbank.smart_bank_backend.service;

import com.smartbank.smart_bank_backend.dto.request.LoginRequest;
import com.smartbank.smart_bank_backend.dto.request.RegisterRequest;
import com.smartbank.smart_bank_backend.dto.responce.ApiResponse;
import com.smartbank.smart_bank_backend.dto.responce.JwtResponse;

public interface AuthService {

    ApiResponse register(RegisterRequest request);

    JwtResponse login(LoginRequest request);

}
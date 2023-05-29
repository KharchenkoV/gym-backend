package com.example.gymapp.service.api;

import com.example.gymapp.service.dto.authentication.AuthenticationRequestDto;
import com.example.gymapp.service.dto.authentication.AuthenticationResponseDto;
import com.example.gymapp.service.dto.authentication.RegisterRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponseDto register(RegisterRequestDto request);
    AuthenticationResponseDto authenticate(AuthenticationRequestDto request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}

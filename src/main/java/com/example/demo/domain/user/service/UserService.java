package com.example.demo.domain.user.service;

import com.example.demo.domain.user.dto.UserDto.LoginRequest;
import com.example.demo.domain.user.dto.UserDto.LoginResponse;
import com.example.demo.domain.user.dto.UserDto.SignupRequest;
import com.example.demo.domain.user.dto.UserDto.SignupResponse;
import com.example.demo.domain.user.entity.User;

public interface UserService {
    SignupResponse singup(SignupRequest signupRequest);

    LoginResponse login(LoginRequest loginRequest);

    User validateEmail(String email);
}

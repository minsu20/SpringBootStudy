package com.example.demo.domain.user.service;

import com.example.demo.domain.user.dto.UserDto;

public interface UserService{
    UserDto.SignupResponse singup(UserDto.SignupRequest signupRequest);
}

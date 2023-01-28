package com.example.demo.domain.user.repository;

import com.example.demo.domain.user.dto.UserDto;

import java.util.Optional;

public interface UserRepositoryCustom {
    Optional<UserDto.SignupResponse> findByEmail(String email);
}

package com.example.demo.domain.user.dto;


import com.example.demo.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "email", source = "signupRequest.email")
    @Mapping(target = "password", source = "signupRequest.password")
    User toEntity(UserDto.SignupRequest signupRequest);
}

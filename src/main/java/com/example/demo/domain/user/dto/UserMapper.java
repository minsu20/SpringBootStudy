package com.example.demo.domain.user.dto;


import com.example.demo.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "email", source = "email")
    @Mapping(target="password", source="password")
    User toEntity(UserDto.SignupRequest signupRequest);
}

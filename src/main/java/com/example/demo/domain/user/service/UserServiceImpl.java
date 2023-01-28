package com.example.demo.domain.user.service;

import com.example.demo.domain.todo.entity.Todo;
import com.example.demo.domain.todo.exception.NotFoundTodoException;
import com.example.demo.domain.user.dto.UserDto;
import com.example.demo.domain.user.dto.UserMapper;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.exception.OverlapUserException;
import com.example.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto.SignupResponse singup(UserDto.SignupRequest signupRequest){
        this.validateOverlap(signupRequest.getEmail());
        User user=userMapper.toEntity(signupRequest);
        user.encryptPassword(passwordEncoder);
        this.userRepository.save(user);
        return new UserDto.SignupResponse(signupRequest.getEmail());
    }

    private void validateOverlap(String email){
        userRepository.findByEmail(email)
                .ifPresent((m -> {
                    throw new OverlapUserException();
                }));
    }
}

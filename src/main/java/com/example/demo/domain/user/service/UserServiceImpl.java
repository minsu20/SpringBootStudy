package com.example.demo.domain.user.service;

import com.example.demo.domain.user.dto.UserDto;
import com.example.demo.domain.user.dto.UserDto.LoginRequest;
import com.example.demo.domain.user.dto.UserDto.LoginResponse;
import com.example.demo.domain.user.dto.UserDto.SignupResponse;
import com.example.demo.domain.user.dto.UserMapper;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.exception.NotFoundEmailException;
import com.example.demo.domain.user.exception.OverlapUserException;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.global.config.security.jwt.JwtTokenProvider;
import com.example.demo.global.dto.TokenInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.demo.domain.user.constant.UserConstants.Role.ROLE_USER;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider tokenProvider;
    private final RedisTemplate redisTemplate;

    @Override
    public SignupResponse singup(UserDto.SignupRequest signupRequest) {
        this.validateOverlap(signupRequest.getEmail());
        User user = userMapper.toEntity(signupRequest);
        user.encryptPassword(passwordEncoder);
        user.setRole(ROLE_USER);
        this.userRepository.save(user);
        return new SignupResponse(signupRequest.getEmail());
    }

    private void validateOverlap(String email) {
        userRepository.findByEmail(email)
                .ifPresent((m -> {
                    throw new OverlapUserException();
                }));
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        TokenInfoResponse tokenInfoResponse = this.validateLogin(loginRequest);
        return LoginResponse.from(tokenInfoResponse);
    }

    public TokenInfoResponse validateLogin(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        Authentication authentication = this.authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        TokenInfoResponse tokenInfoResponse = this.tokenProvider.createToken(authentication);
        return tokenInfoResponse;
    }

    @Override
    public User validateEmail(String email) {
        return this.userRepository.findByEmail(email).orElseThrow(NotFoundEmailException::new);
    }
}

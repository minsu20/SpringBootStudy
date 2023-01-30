package com.example.demo.domain.user.controller;

import com.example.demo.domain.user.constant.UserConstants;
import com.example.demo.domain.user.dto.UserDto.LoginRequest;
import com.example.demo.domain.user.dto.UserDto.LoginResponse;
import com.example.demo.domain.user.dto.UserDto.SignupRequest;
import com.example.demo.domain.user.dto.UserDto.SignupResponse;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.global.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
@Api(tags = "User API")
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "회원가입을 합니다.")
    @PostMapping("/signup")
    public ResponseEntity<ResponseDto<SignupResponse>> singupUser(@Valid @ModelAttribute SignupRequest signupRequest) {
        return ResponseEntity.ok(ResponseDto.create(UserConstants.EBoardResponseMessage.SIGNUP_SUCCESS.getMessage(), this.userService.singup(signupRequest)));
    }

    @ApiOperation(value = "로그인", notes = "로그인을 합니다.")
    @PostMapping("/login")
    public ResponseEntity<ResponseDto<LoginResponse>> loginUser(@Valid @ModelAttribute LoginRequest loginRequest) {
        return ResponseEntity.ok(ResponseDto.create(UserConstants.EBoardResponseMessage.LOGIN_SUCCESS.getMessage(), this.userService.login(loginRequest)));
    }
}

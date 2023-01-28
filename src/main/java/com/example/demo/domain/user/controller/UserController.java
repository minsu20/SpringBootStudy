package com.example.demo.domain.user.controller;

import com.example.demo.domain.todo.service.TodoService;
import com.example.demo.domain.user.constant.UserConstants;
import com.example.demo.domain.user.dto.UserDto;
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
@Api(tags="User API")
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "회원가입을 합니다.")
    @PostMapping
    public ResponseEntity<ResponseDto<UserDto.SignupResponse>> singupUser(@Valid @ModelAttribute UserDto.SignupRequest signupRequest){
        return ResponseEntity.ok(ResponseDto.create(UserConstants.EBoardResponseMessage.SIGNUP_SUCCESS.getMessage(),this.userService.singup(signupRequest)));
    }
}

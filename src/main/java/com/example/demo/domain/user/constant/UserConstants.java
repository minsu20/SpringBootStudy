package com.example.demo.domain.user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

public class UserConstants {

    @Getter
    @RequiredArgsConstructor
    public enum EBoardResponseMessage{
        SIGNUP_SUCCESS("회원가입에 성공했습니다"),
        LOGIN_SUCCESS("로그인에 성공했습니다");
        private final String message;
    }

    @Getter
    @RequiredArgsConstructor
    public enum BoardExceptionList {
        NOT_FOUND_LOGIN_ID("U0001", HttpStatus.NOT_FOUND, "해당 loginId로 User를 찾을 수 없습니다."),
        NOT_FOUND_EMAIL("U0002", HttpStatus.NOT_FOUND, "해당 email로 User를 찾을 수 없습니다."),
        OVERLAP_USER("U0003", HttpStatus.BAD_REQUEST, "이미 존재하는 회원입니다");

        private final String errorCode;
        private final HttpStatus httpStatus;
        private final String message;
    }

    @Getter
    public enum Role {
        ROLE_USER, ROLE_ADMIN
    }
}

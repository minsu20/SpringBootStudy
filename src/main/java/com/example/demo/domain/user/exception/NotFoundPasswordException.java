package com.example.demo.domain.user.exception;

import com.example.demo.domain.user.constant.UserConstants;

public class NotFoundPasswordException extends UserException {
    public NotFoundPasswordException() {
        super(UserConstants.UserExceptionList.NOT_FOUND_PASSWORD.getErrorCode(),
                UserConstants.UserExceptionList.NOT_FOUND_PASSWORD.getHttpStatus(),
                UserConstants.UserExceptionList.NOT_FOUND_PASSWORD.getMessage());
    }
}
